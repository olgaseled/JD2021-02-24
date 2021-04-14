package by.it.belazarovich.jd02_02;

public class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name ="\tCashier №" + number+" ";
    }

    @Override
    public void run() {
        System.out.println(this + "started to work");

        while (!Manager.shopIsClosed()) {
            Buyer buyer = BuyersInQueue.poll();
            if (buyer != null) {
                synchronized (buyer.getMONITOR()) {
                    System.out.println(this + "started service for " + buyer);
                    int timeout = Utils.getRandom(2000, 5000);
                    Utils.sleep(timeout);
                    System.out.println(this + "finished service for " + buyer);
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            } else {
                Utils.sleep(1);
            }

        }

        System.out.println(this + "finished working");

    }

    @Override
    public String toString() {
        return name;
    }
}
