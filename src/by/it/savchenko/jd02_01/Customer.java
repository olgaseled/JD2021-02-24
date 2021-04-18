package by.it.savchenko.jd02_01;

class Customer extends Thread implements ICustomer, IUseBasket {

    public Customer(int number) {
        super("Customer #" + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
        takeBasket();
        putGoodsToBasket();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "goes to the store");
    }
    @Override
    public void takeBasket() {
        System.out.println(this + "took a Basket");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choose goods");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "finished choose goods");
    }


    @Override
    public void goOut() {
        System.out.println(this + "leaves the store");
    }

    @Override
    public String toString() {
        return this.getName();
    }



    @Override
    public void putGoodsToBasket()  {

        int numberOfGoods = Util.getRandom(1, 4);
        for (int i = 0; i < numberOfGoods; i++) {
            String nameOfGood = ListProduct.getRandomProduct();
            Double priceOfGood = ListProduct.basket.get(nameOfGood);
            System.out.println(this + "put " + nameOfGood + " costing " + priceOfGood + " to the Basket");
            int timeout = Util.getRandom(500, 2000);
            Util.sleep(timeout);
        }
        System.out.println(this + "finished choosing goods");
    }

    }

