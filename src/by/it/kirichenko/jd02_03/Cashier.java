package by.it.kirichenko.jd02_03;


public class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "\tCashier #" + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Manager.storeIsClosed()) {
            Buyer buyer = QueueBuyers.poll();
            if (buyer != null) {
                synchronized (buyer.getMONITOR()) {
                    System.out.println(this + "started service " + buyer);
                    int timeout = Util.getRandom(2000, 5000);
                    Util.sleep(timeout);
                    buyer.viewBasket();
                    System.out.println(this + "finished service " + buyer);
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            } else {
                //need waiting
                Thread.onSpinWait();
                Util.sleep(1);
            }
        }

        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
