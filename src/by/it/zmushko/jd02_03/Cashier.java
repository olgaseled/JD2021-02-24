package by.it.zmushko.jd02_03;

public class Cashier implements Runnable {

    private String name;
    private Contex contex;

    public Cashier(int number, Contex contex) {
        name = "name cashier = " + number + " ";
        this.contex = contex;
    }

    @Override
    public void run() {
        System.out.println(this + " start worked");
        while (!contex.getManager().storeClose()) {
            Buyer buyer = contex.getQueuePeoples().getOnePeople();
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
