package by.it.korotkevich.jd02_01;

class Customer extends Thread implements ICustomer, IUseBasket {

    public Customer(int number) {
        super("Customer #" + number + " ");
    }


    @Override
    public void run() {
        enterMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
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
        Basket.putGoodsToBasket(this, goodsAmount);
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
