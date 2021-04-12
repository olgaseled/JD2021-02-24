package by.it.khrolovich.jd02_01;

public class Customer extends Thread implements ICustomer, IUseBasket {

    //int number;//номер покупателя
    private Basket basket = new Basket();//его личная корзинка
    public boolean pensioneer;

    public Customer(int numberCustomer, boolean pensioneer) {
     /*   this.number = numberCustomer;
        this.setName("Покупатель №"+numberCustomer+" ");
        start();*/
        super("Customer №" + numberCustomer + " ");
        this.pensioneer = pensioneer;
        if (pensioneer) {
            this.setName("Pensioneer-"+this.getName());
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();//покупатель взял корзину
        chooseGoods();//выбрал товар
        //putGoodsToBasket();//положил в корзину
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to the Store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose good");

        int countOfGoods = Util.getRandom(1, 4);
        for (int i = 0; i < countOfGoods; i++) {
            int pause = Util.getRandom(500, 2000);//от 0.5 до 2х секунд
            Util.Sleep(pause, true);//выбираем товар от 0.5 до 2х секунд
            putGoodsToBasket();//кладем в корзину
        }
        System.out.println(this + "finished to choose good");
    }

    @Override
    public void goOut() {
        System.out.println(this + "go out from the Store");
    }

    @Override
    public String toString() {

        //return super.toString();
        return this.getName();
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
}
