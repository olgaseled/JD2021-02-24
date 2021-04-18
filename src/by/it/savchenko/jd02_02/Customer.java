package by.it.savchenko.jd02_02;

import by.it.savchenko.jd02_01.ListProduct;

class Customer extends Thread implements ICustomer {

    private final Object MONITOR;

    private boolean waiting = false;

    public Object getMONITOR() {
        return MONITOR;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    Customer(int number) {
        super("Customer #" + number + " ");
        MONITOR = this;
        Manager.newCustomer();

    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Manager.completeCustomer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "goes to the store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started  choose goods");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "finished  choose goods");
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
    public void putGoodsToBasket()  {

        int numberOfGoods = Util.getRandom(1, 4);
        for (int i = 0; i < numberOfGoods; i++) {
            String nameOfGood = ListProduct.getRandomProduct();
            Double priceOfGood = ListProduct.basket.get(nameOfGood);
            System.out.println(this + "put " + nameOfGood + " costing " + priceOfGood + " to the Basket");
            int timeout = Util.getRandom(500, 2000);
            Util.sleep(timeout);
        }
        System.out.println(this + "finished choosing goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "leaves the store");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
