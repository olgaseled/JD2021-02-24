package by.it.seledtsova.jd02_01;

import java.util.HashMap;
import java.util.LinkedHashMap;
/*
У каждого покупателя с корзиной (Basket) собирается набор от 1..4 товаров (Good)
 из фиксированного списка с ценой (рекомендуется hashmap, где товар –key,цена –value).
Время на каждую операцию от 0,5до 2 секунд, итог операции –в консоль.
 */

public class Basket extends Thread implements IUseBasket {
/*
public Buyer(int number) {
        super("Customer #" + number + " ");
    }
 */

   LinkedHashMap <String,Integer> basket= new LinkedHashMap<>(4);
    {
        basket.put ("Milk", 2);
        basket.put("Bread", 1);
        basket.put("Cheese", 3);
        basket.put("Chocolate", 4);
    }


    @Override
    public void takeBasket() {
        System.out.println(this+"The buyer takes the basket");
        int pause = Util.getRandom(500, 2000); //
        Util.sleep(pause);
        System.out.println();
    }

    @Override
    public void putProductToTheBasket() {
            System.out.println(this+"The buyer put product to the basket");
            int pause = Util.getRandom(500, 2000); //
            Util.sleep(pause);
        System.out.println(this+"The buyer put product to the basket");
        }

    
}

