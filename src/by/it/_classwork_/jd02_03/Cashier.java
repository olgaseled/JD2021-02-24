package by.it._classwork_.jd02_03;

public class Cashier implements Runnable {

    private String name;

    private Context context;

    public Cashier(int number, Context context) {
        name = "\tCashier #" + number + " ";
        this.context = context;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!context.getManager().storeIsClosed()) {
            Customer customer = context.getQueueCustomers().poll();
            if (customer != null) {
                synchronized (customer.getMONITOR()) {
                    System.out.println(this + "started service " + customer);
                    int timeout = Util.getRandom(2000, 5000);
                    Util.sleep(timeout);
                    System.out.println(this + "finished service " + customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                //need waiting
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
