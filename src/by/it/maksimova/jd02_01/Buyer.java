package by.it.maksimova.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    public Buyer(int number) {
        super("Buyer " + number+" ");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "entered the Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choosing goods");
        int timeout = Utils.getRandom(500, 2000);
        Utils.sleep(timeout);
        System.out.println(this + "finished choosing goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "leaves the Market");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "took a Basket");
        int timeout = Utils.getRandom(500, 2000);
        Utils.sleep(timeout);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + "put products in Basket");

    }
}

