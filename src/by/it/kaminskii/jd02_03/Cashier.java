package by.it.kaminskii.jd02_03;/* created by Kaminskii Ivan
 */

public class Cashier implements Runnable {

private BuyerQueue buyerQueue;

    private String name;

    public Cashier(int number, BuyerQueue buyerQueue) {
        name = "\tCashier #" + number + " ";
        this.buyerQueue = buyerQueue;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Manager.marketIsClosed()) {
            Buyer buyer = buyerQueue.pull();
            if (buyer != null) {
                synchronized (buyer.getMONITOR()) {
                    System.out.println(this + "started service " + buyer);
                    int timeout = Helper.randomValue(2000, 5000);
                    Helper.sleep(timeout);
                    System.out.println(this + "finished service " + buyer);
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            } else {
                Helper.sleep(1);
            }

        }

        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
