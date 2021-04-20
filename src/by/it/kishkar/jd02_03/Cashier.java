package by.it.kishkar.jd02_03;

public class Cashier implements Runnable{

    private String name;

    private Queue queue;


    public Cashier(int number, Queue queue) {

        name = "\tCashier #" + number + " ";
        this.queue=queue;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Manager.storeIsClosed()) {
            Buyer buyer = queue.poll();
            if (buyer != null) {
                synchronized (buyer.getMONITOR()) {
                    System.out.println(this + "started service " + buyer);
                    int timeout = Helper.getRandom(2000, 5000);
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
