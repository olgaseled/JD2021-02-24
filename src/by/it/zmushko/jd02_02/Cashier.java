package by.it.zmushko.jd02_02;

public class Cashier implements Runnable {

    public String name;

    public Cashier(int number) {
        name = "name cashier = " + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + " start worked");
        while (!Manager.storeClose()) {
            Buyer buyer = QueuePeoples.getOnePeople();
            if (buyer != null) {
                synchronized (buyer.takeMonitor()) {
                    System.out.println(this + " START work with " + buyer);
                    Support.sleep(Support.getRandom(2000, 5000));
                    System.out.println(this + " FINISH work with " + buyer);
                    buyer.waiting(false);
                    buyer.notify();
                }
            } else {
                Support.sleep(1);
            }
        }
        System.out.println(this + " GO HOME");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
