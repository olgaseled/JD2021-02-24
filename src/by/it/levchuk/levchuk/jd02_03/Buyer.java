package by.it.levchuk.levchuk.jd02_03;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private final Object MONITOR;
    public boolean waiting = false;
    Basket basket=new Basket();
    private static Semaphore semaphore = new Semaphore(20);
    private final Conditions conditions;

    Object getMONITOR() {
        return MONITOR;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }


    public Buyer(int number, Conditions conditions) {
        super("Покупатель №" + number + " ");
        MONITOR = this;
        this.conditions = conditions;
        conditions.getSeniorCashier().newBuyer();
    }

    @Override
    public void run() {
        try {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        semaphore.acquire();
    }catch(InterruptedException e) {
        e.printStackTrace();
    }finally {
        semaphore.release();
    }
        goToQueue();
        goOut();
        conditions.getSeniorCashier().lastBuyer();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Вошёл в магазин");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "Взял корзину");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Выбирает товары");
        int timeout = Tools.getRandom(500, 2000);
        Tools.sleep(timeout);
        System.out.println(this + "Выбрал товары");
    }

    @Override
    public void putGoodsToBasket() {
        int goodsAmount = Tools.getRandom(1, 4);
        basket.putGoodsToBasket(this, goodsAmount);
        System.out.println(this + "Положил товары в корзину");
    }


    @Override
    public void goToQueue() {
        synchronized (MONITOR) {
            conditions.getQueueBuyers().add(this);
            System.out.println(this + "Стал в очередь");
            waiting = true;
            while (waiting) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "Покидает магазин");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
