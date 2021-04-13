package by.it.runcov.jd02_03;


class Buyer extends Thread implements IBuyer {

    private final Object MONITOR;

    private final Context context;

    private boolean waiting = false;

    public Object getMONITOR() {
        return MONITOR;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

     Buyer(int number, Context context) {
        super("Buyer №" + number + " ");
        MONITOR = this;
        this.context = context;
        context.getManager().newBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        context.getManager().completeBuyer();
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
            context.getQueueBuyers().add(this);
            waiting = true;
            while (waiting) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
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
