package by.it.dudko.jd02_02;

import java.util.List;

public class Customer extends Thread implements ICustomer, IUseBasket {

    private final Object MONITOR;

    private boolean waiting = false;

    double slowRatio = 1.0;

    boolean pensioner = false;

    Basket basket;

    public Object getMONITOR() {
        return MONITOR;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Customer(int number) {
        super(String.format("Customer #%d", number));
        MONITOR = this;
        Manager.newCustomer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        putGoodsToBasket(chooseGoods());
        goToQueue();
        goOut();
        Manager.completeCustomer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enters the store");
    }

    @Override
    public List<Good> chooseGoods() {
        System.out.println(this + " started choosing goods");
        int goodsCount = StoreUtil.getRandom(1, Config.MAX_GOODS_IN_BASKET);
        List<Good> goods = StoreUtil.getRandomGoods(goodsCount);
        int actionTime = StoreUtil.getRandom(500, (int)(2000 * slowRatio));
        StoreUtil.sleep(actionTime);
        System.out.println(this + " finished choosing goods");
        return goods;
    }

    @Override
    public void goToQueue() {
        synchronized (MONITOR) {
            QueueCustomers.add(this);
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
        System.out.println(this + " leaves the store");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        basket = new Basket();
        int actionTime = StoreUtil.getRandom(500, (int)(2000 * slowRatio));
        StoreUtil.sleep(actionTime);
        System.out.println(this + " took a basket");
    }

    @Override
    public void putGoodsToBasket(List<Good> goods) {
        int actionTime;
        for (Good good : goods) {
            actionTime = StoreUtil.getRandom(500, (int)(2000 * slowRatio));
            StoreUtil.sleep(actionTime);
            basket.putGood(good);
        }
        System.out.printf("%s put %d goods in basket\n", this, goods.size());
    }

    @Override
    public List<Good> takeOutAllGoods() {
        return basket.getAllGoods();
    }
}
