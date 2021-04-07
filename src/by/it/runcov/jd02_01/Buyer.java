package by.it.runcov.jd02_01;

class Buyer extends Thread implements IBuyer,IUseBasket{

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
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "finished choose goods");
    }

    @Override
    public void takeBasket() {

    }

    @Override
    public void putGoodsToBasket() {

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
