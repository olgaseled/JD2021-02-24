package by.it._classwork_.jd02_02;

public class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "\tCashier #" + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Manager.storeIsClosed()) {
            Customer customer = QueueCustomers.poll();
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
