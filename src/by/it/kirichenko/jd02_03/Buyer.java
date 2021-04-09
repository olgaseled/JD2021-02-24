package by.it.kirichenko.jd02_03;

import java.util.Map;

class Buyer extends Thread implements BuyerActions, BuyerActionsWithBasket {

    private final Object MONITOR;

    private boolean waiting = false;

    private int numberBuyer;
    Basket basket;

    public Object getMONITOR() {
        return MONITOR;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Buyer(int numberBuyer) {
        super("Buyer number " + numberBuyer + " ");
        this.numberBuyer = numberBuyer;
        MONITOR = this;
        Manager.newBuyer();
    }

    @Override
    public void goToQueue() {
        synchronized (MONITOR) {
            QueueBuyers.add(this);
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
    public void run() {
        storeEntrace();
        takeBasket();
        productSelection();
        //viewBasket();
        goToQueue();
        exitingStore();
        Manager.completeBuyer();
    }

    public void viewBasket() {
        System.out.println(this + " take products: "+basket.getBasket());
    }

    @Override
    public void storeEntrace() {
        System.out.println(this + " entered the store.");
    }

    @Override
    public void productSelection() {
        System.out.println(this + " started choosing products.");

        int countProducts = Util.getRandom(1,4);

        for (int i = 0; i < countProducts; i++) {
            putProductInBasket();
        }

        System.out.println(this + " finished choosing products.");
    }

    @Override
    public void exitingStore() {
        System.out.println(this + " left the store.");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        basket = new Basket(numberBuyer);
        System.out.println(this + " take basket.");
    }

    @Override
    public void putProductInBasket() {
        Map<String, Double> product = StoreWindow.getRandomProduct();
        basket.addProductInBasket(product);
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);

    }
}
