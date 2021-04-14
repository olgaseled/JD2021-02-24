package by.it.maksimova.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    public Buyer(int number) {
        super("Buyer " + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "entered the Market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "took a Basket");
        int timeout = Utils.getRandom(500, 2000);
        Utils.sleep(timeout);
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choosing goods");
        int timeout = Utils.getRandom(500, 2000);
        Utils.sleep(timeout);

    }

    @Override
    public void putGoodsToBasket() {

        int numberOfGoods = Utils.getRandom(1, 4);
        for (int i = 0; i < numberOfGoods; i++) {
            String nameOfGood = ListOfGoods.getRandomGood();
            Double priceOfGood = ListOfGoods.listOfGoods.get(nameOfGood);
            System.out.println(this + "put " + nameOfGood + " costing " + priceOfGood + " to the Basket");
            int timeout = Utils.getRandom(500, 2000);
            Utils.sleep(timeout);
        }
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
}

