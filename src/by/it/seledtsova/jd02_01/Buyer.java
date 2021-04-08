package by.it.seledtsova.jd02_01;

/*
Напишите программу, моделирующую поток покупателей Buyerв магазине.
Каждую секунду в магазин приходят от 0 до 2 новых покупателей в течение двух минут.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer extends Thread implements IBuyer,Runnable, IUseBasket {


    public Buyer(int number) {
        super("Customer #" + number + " ");
    }


    @Override
    public void run(){   // выделили наш поток. Покупатель пришел в зал магазина,выбирает и покупает товар
        enterToMarket();
        takeBasket();
        chooseGoods();
        putProductToTheBasket();
        goOut();
    }

// Реализовали методы класса предка enterToMarket(), chooseGoods(), goOut()
    @Override
    public void enterToMarket() {
        System.out.println(this+"The buyer has entered to the supermarket");

    }
    @Override
    public void takeBasket() {
        System.out.println(this + "The buyer takes the basket");
        int pause = Util.getRandom(500, 2000); //
        Util.sleep(pause);
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"The buyer star to choose products");
        int pause = Util.getRandom(500, 2000);
        Util.sleep(pause);
        System.out.println(this + "finished choose goods");
    }

    @Override
    public void putProductToTheBasket() {
        List<Integer> basketProduct=new ArrayList<>();
        int pause = Util.getRandom(500, 2000); //
        Util.sleep(pause);
        int howMuchProducts=Util.getRandom(1,4);
        for (int product = 0; product < basketProduct.size(); product++) {
            basketProduct.add(howMuchProducts);
        }


        System.out.println(this + "The buyer put "+howMuchProducts+" product to the basket");
    }


    @Override
    public void goOut() {
        System.out.println(this+"The buyer has left the supermarket");
    }


    @Override
    public String toString() {
        return this.getName();
    }


}
