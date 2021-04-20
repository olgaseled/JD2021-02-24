package by.it.belazarovich.jd02_03;

public class Buyer extends Thread implements IBuyer {

    private final Object MONITOR;
private final Context context;
    public Object getMONITOR() {
        return MONITOR;
    }

    private boolean waiting = false;

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Buyer(int number, Context context) {

        super("Buyer " + number + " ");
        MONITOR = this;
        this.context=context;
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
        System.out.println(this + "entered the Shop");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choosing goods");
        int timeForChoosingGoods = Utils.getRandom(500, 2000);
        Utils.sleep(timeForChoosingGoods);
        System.out.println(this + "finished choosing goods");
    }

    @Override
    public void goToQueue() {
        synchronized (MONITOR) {
            context.getQueueOfBuyers().add(this);
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
        System.out.println(this + "leaves the Shop");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

