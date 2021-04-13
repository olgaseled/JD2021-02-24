package by.it.papruga.jd02_03;

import java.util.concurrent.Semaphore;

public class Customer extends Thread implements ICustomer, IUseBasket {

    private boolean waiting = false;

    private final Context context;

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public boolean isWaiting() {
        return waiting;
    }

    private static Semaphore semaphore = new Semaphore(Config.SHOPPING_ROOM_CAPACITY);

    public Customer(int number, Context context) {

        super("Customer #" + number + " ");
        this.context = context;
        context.getManager().newCustomer();

    }

    private Basket basket = new Basket();

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        try {
            semaphore.acquire();
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
        goToQueue();
        goOut();
        context.getManager().completeCustomer();
    }

    @Override
    public void enterToMarket() {

        System.out.println(this + "goes to the market");

    }

    @Override
    public void goToQueue() {

        context.getQueueCustomers().add(this);
        System.out.println(this + "add to Queue");

        if (context.getQueueCashiers().getCashiersSize() > 0 &&  context.getManager().getCountQueueIn() % 5 == 0)
        {
            Cashier cashier = context.getQueueCashiers().pull();
            synchronized (cashier){
                cashier.notify();
                cashier.setWaiting(false);
            }

        }

        waiting = true;
        synchronized (this) {
            while (waiting)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(this + "left the Queue");

    }

    @Override
    public void chooseGoods() {

        System.out.println(this + "started choose goods");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);

        int goodsCount = Util.getRandom(1, 4);

        for (int i = 0; i < goodsCount; i++) {

            basket.put(ListGoods.randomGood());

        }

        putGoodsToBasket();


        System.out.println(this + "finished choose goods");
    }

    @Override
    public void goOut() {

        System.out.println(this + "leaves this store");

    }

    @Override
    public void takeBasket() {

        System.out.println(this + "take basket");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);

    }

    @Override
    public String showBasket() {
        return basket.toString();
    }

    @Override
    public void putGoodsToBasket() {

        System.out.println(this + "put goods to basket");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);

    }

    @Override
    public String toString() {
        return this.getName();
    }
}
