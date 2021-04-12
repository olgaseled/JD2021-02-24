package by.it.korotkevich.jd02_03;

class Customer extends Thread implements ICustomer, IUseBasket {
    private final Object MONITOR;

    private boolean waiting = false;

    Basket basket = new Basket();

    private final Context context;

    Object getMONITOR() {
        return MONITOR;
    }

    void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    Customer(int number, Context context) {
        super("Customer #" + number + " ");
        MONITOR = this;
        this.context = context;
        context.getManager().newCustomer();;
    }


    @Override
    public void run() {
        enterMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        joinQueue();
        goOut();
        context.getManager().servedCustomer();
    }

    @Override
    public void enterMarket() {
        System.out.println(this + "entered the store.");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "took a basket.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "is choosing goods.");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "finished choosing goods.");
    }

    @Override
    public void putGoodsToBasket() {
        int goodsAmount = Util.getRandom(1, 4);
        basket.putGoodsToBasket(this, goodsAmount);
    }

    private void joinQueue() {
        synchronized (MONITOR) {
            context.getQueueOfCustomers().add(this);
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
        System.out.println(this + "leaves the store.");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
