package by.it.runcov.jd02_02;


class Buyer extends Thread implements IBuyer {

    private final Object MONITOR;

    private boolean waiting = false;

    public Object getMONITOR() {
        return MONITOR;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Buyer(int number) {
        super("Buyer №" + number + " ");
        MONITOR = this;
        Manager.newBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Manager.completeBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "goes to the shop");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choose goods");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "finished choose goods");
    }

    @Override
    public void goToQueue() {
        synchronized (MONITOR) {
            QueueBuyers.add(this);
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
    public void goOut() {
        System.out.println(this + "leaves the shop");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
