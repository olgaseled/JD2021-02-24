package by.it.runcov.jd02_03;

public class Cashier implements Runnable {

    private String name;

    private Context context;

    public Cashier(int number, Context context) {
        name = "\tCashier №" + number + " ";
        this.context = context;
    }


    @Override
    public void run() {
        System.out.println(this + "opening");
        while (!context.getManager().shopIsClosed()) {
            Buyer buyer = context.getQueueBuyers().poll();
            if (buyer != null) {
                synchronized (buyer.getMONITOR()) {
                    System.out.println(this + "started service " + buyer);
                    int timeout = Util.getRandom(2000, 5000);
                    Util.sleep(timeout);
                    System.out.println(this + "finished service " + buyer);
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            } else {
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
