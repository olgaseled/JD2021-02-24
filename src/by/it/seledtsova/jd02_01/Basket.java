package by.it.seledtsova.jd02_01;

import java.util.HashMap;

public class Basket extends Thread implements IUseBasket {

    HashMap <String,Integer> basket= new HashMap<>(4);
    {
        basket.put("Milk", 2);
        basket.put("Bread", 1);
        basket.put("Cheese", 3);
        basket.put("Chocolate", 4);
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

