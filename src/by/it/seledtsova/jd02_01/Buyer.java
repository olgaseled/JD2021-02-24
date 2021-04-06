package by.it.seledtsova.jd02_01;

/*
Напишите программу, моделирующую поток покупателей Buyerв магазине.
Каждую секунду в магазин приходят от 0 до 2 новых покупателей в течение двух минут.
 */


public class Buyer extends Thread implements IBuyer, Runnable, IUseBasket {


    public Buyer(int number) {
        super("Customer #" + number + " ");
    }

    public void run(){   // выделили наш поток. Покупатель пришел в зал магазина,выбирает и покупает товар
        enterToMarket();
        chooseGoods();
        goOut();
    }

// Реализовали методы класса предка enterToMarket(), chooseGoods(), goOut()
    @Override
    public void enterToMarket() {
        System.out.println(this+"The buyer has entered to the supermarket");

    }
    @Override
    public void chooseGoods() {
        System.out.println(this+"The buyer star to choose products");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "finished choose goods");
    }


    @Override
    public void goOut() {
        System.out.println(this+"The buyer has left the supermarket");
    }


    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this+"The buyer takes the basket");
            }

    @Override
    public void putProductToTheBasket() {
        System.out.println(this+"The buyer put product to the basket");
        int timeout = Util.getRandom(500, 2000); //  
        Util.sleep(timeout);
    }
}
