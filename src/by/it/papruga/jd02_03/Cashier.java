package by.it.papruga.jd02_03;

public class Cashier implements Runnable, ICashier {

    private final int number;
    private Context context;
    private boolean waiting = false;
    public Basket basket = new Basket();
    static final Object MONITOR = new Object();

    public Cashier(int number, Context context) {
        this.number = number;
        this.context = context;
    }


    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }


    @Override
    public void run() {
        goToCashierQueue();
        opened();
        startService();
        closed();
    }

    @Override
    public void goToCashierQueue() {

        QueueCashiers.add(this);
        this.setWaiting(true);
        this.waiting();
        synchronized (this) {
            while (waiting)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

    }

    @Override
    public void waiting() {

        System.out.println(this + "is waiting for work");

    }

    @Override
    public void opened() {

        System.out.println(this + "opened");
    }


    @Override
    public void startService() {

        while (!context.getManager().storeIsClosed()){
            Customer customer = context.getQueueCustomers().pull();
            if (customer!=null){
                System.out.println(this+"start service for "+customer);
                int timeout = Util.getRandom(500, 2000);
                Util.sleep(timeout);
                System.out.println(customer + "bought:"  + customer.showBasket());
                System.out.println(this+"finish service for "+customer);
                Util.sleep(timeout);
                synchronized (customer)
                {
                    customer.setWaiting(false);
                    customer.notify();
                }
            }
            else {
                break;
            }

        }

    }

    @Override
    public void finishService() {

    }

    @Override
    public void closed() {

        System.out.println(this + "closed");

    }

    @Override
    public String toString() {
        return "Cashier N#"+ number +" ";
    }
}
