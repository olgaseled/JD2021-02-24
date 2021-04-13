package by.it.kishkar.jd02_02;

class Buyer extends Thread implements IBuyer {
    private final Object MONITOR;

    private boolean waiting = false;

    public Object getMONITOR() {
        return MONITOR;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }


    Buyer (int number) {
        super("Buyer # " + number);
        MONITOR=this;
        Manager.newCustomer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Manager.completeCustomer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" entered to store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" started choose goods");
        System.out.println(this+" finished choose goods");
       int timeout = Helper.getRandom(500, 2000);
       Helper.sleep (timeout);
    }

    @Override
    public  void goToQueue() {
        synchronized (MONITOR) {
            Queue.add(this);
            waiting = true;
            while (waiting) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void goOut() { System.out.println(this+ " left from the store");
    }
}
