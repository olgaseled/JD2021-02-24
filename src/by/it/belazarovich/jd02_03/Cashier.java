package by.it.belazarovich.jd02_03;

public class Cashier implements Runnable {


    private String name;
    private Context context;
    public Cashier(int number, Context context) {
        name ="\tCashier №" + number+" ";
        this.context=context;
    }

    @Override
    public void run() {
        System.out.println(this + "started to work");

        while (!context.getManager().shopIsClosed()) {
            Buyer buyer = context.getQueueOfBuyers().poll();
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
