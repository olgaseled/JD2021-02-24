package by.it.kaminskii.jd02_02;/* created by Kaminskii Ivan
 */

public class Cashier implements Runnable{
    private String name;

    public Cashier(int number) {
        name = "\tCashier #" + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Manager.marketIsClosed()) {
            Buyer buyer = BuyerQueue.buyerPull();
            if (buyer != null) {
                synchronized (buyer.getMONITOR()) {
                    System.out.println(this + "started service " + buyer);
                    int timeout = Helper.randomValue(2000,5000);
                    Helper.sleep(timeout);
                    System.out.println(this + "finished service " + buyer);
                    buyer.setSomeWaiting(false);
                    buyer.notify();
                }
            } else {
                //need waiting
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
