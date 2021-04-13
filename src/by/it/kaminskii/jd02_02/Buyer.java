package by.it.kaminskii.jd02_02;/* created by Kaminskii Ivan
 */


import java.util.StringJoiner;

class Buyer extends Thread implements IBuyer, IUseBasket {

    final Object MONITOR_BUYER;
    boolean waiting = false;

    public Buyer(int whichOne) {
        super("Buyer№" + whichOne + " ");
        MONITOR_BUYER=this;
        Manager.newBuyer();
    }
    public Object getMONITOR() {
        return MONITOR_BUYER;
    }



    public void setSomeWaiting(boolean waiting) {
        this.waiting = waiting;
    }

//    Customer(int number) {
//        super("Customer #" + number + " ");
//        MONITOR = this;
//        Manager.newCustomer();
    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        choosePurchase();
        putGoodsToBasket();
        goToQueue();
        leavingTheMarket();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "come to market");
    }

    @Override
    public void takeBasket() {
        System.out.println("buyer take basket");
        int sleepTime = Helper.randomValue(500, 2000);
        Helper.sleep(sleepTime);
    }

    @Override
    public void choosePurchase() {
        System.out.println(this + "choosing some Purchase");
        int sleepTime = Helper.randomValue(500, 2000);
        Helper.sleep(sleepTime);
        System.out.println(this + "finished choosing");
    }

    @Override
    public void putGoodsToBasket() {
        synchronized (MONITOR_BUYER) {
            int sleepTime = Helper.randomValue(500, 2000);
            Helper.sleep(sleepTime);
            StringJoiner basketJoiner = new StringJoiner(",");
            for (int i = 0; i < Helper.randomValue(1, 4); i++) {
                basketJoiner.add(Basket.basketGoods().get(Helper.randomValue(0, 9)));
            }
            System.out.println(this + "put: " + basketJoiner + " to basket");
        }
    }

    @Override
    public void goToQueue() {
        BuyerQueue.buyerAdd(this);
        waiting = true;
        while (waiting) {
            try {
                MONITOR_BUYER.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void leavingTheMarket() {
        System.out.println(this + "steal somthing and leave the market");

    }

    @Override
    public String toString() {
        return this.getName();
    }
}
