package by.it.papruga.jd02_01;

public class Customer extends Thread implements ICustomer, IUseBasket {

    public Customer(int number) {

        super("Customer #" + number + " ");

    }

    boolean pensioneer = false;

    double slowRatio = Config.K_SLOW_RATIO;

    private Basket basket = new Basket();

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {

        System.out.println(this + "goes to the market");

    }

    @Override
    public void chooseGoods() {

        System.out.println(this + "started choose goods");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout*slowRatio);

        int goodsCount = Util.getRandom(1, 4);

        for (int i = 0; i < goodsCount; i++) {

            basket.put(ListGoods.randomGood());

        }

        System.out.println(this + "choose:" + basket);

        putGoodsToBasket();


        System.out.println(this + "finished choose goods");
    }

    @Override
    public void goOut() {

        System.out.println(this + "leaves this store");

    }

    @Override
    public void takeBasket() {

        System.out.println(this + "take basket");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout*slowRatio);

    }

    @Override
    public void putGoodsToBasket() {

        System.out.println(this + "put goods to basket");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout*slowRatio);

    }

    @Override
    public String toString() {
        return this.getName();
    }
}
