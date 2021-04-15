package by.it.runcov.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private final Basket basket = new Basket();

    public Buyer(int number) {
        super("Buyer №" + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        takeBasket();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "goes to the shop");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choose goods");
        int goods = Util.getRandom(1, 4);
        for (int i = 0; i < goods; i++) {
            int timeout = Util.getRandom(500, 2000);
            Util.sleep(timeout);
            putGoodsToBasket();
        }
        System.out.println(this + "finished choose goods");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "take the basket");

    }

    @Override
    public void putGoodsToBasket() {
        Good good = ListGoods.randomGood();
        basket.put(good);
        System.out.println(this + " put to the Basket " + good);
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
