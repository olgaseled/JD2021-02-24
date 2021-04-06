package by.it.seledtsova.jd02_01;


import by.it.seledtsova.jd01_11.ListB;

import java.util.*;

/*
У каждого покупателя с корзиной (Basket) собирается набор от 1..4 товаров (Good)
 из фиксированного списка с ценой (рекомендуется hashmap, где товар –key,цена –value).
Время на каждую операцию от 0,5до 2 секунд, итог операции –в консоль.
 */

public class BasketProduct extends Thread implements IUseBasket {


   public static  Map<String, Double> basketProduct () {
        Map<String, Double> basketProduct = new HashMap<>();
        basketProduct.put("Milk", 2.15);
        basketProduct.put("Bread", 1.85);
        basketProduct.put("Cheese", 3.35);
        basketProduct.put("Chocolate", 4.10);
        return basketProduct;
    }


    @Override
    public void takeBasket() {
        System.out.println(this + "The buyer takes the basket");
        int pause = Util.getRandom(500, 2000); //
        Util.sleep(pause);

    }

    @Override
    public void putProductToTheBasket() {
       List<Integer> basketProduct=new ArrayList<>();
        int howMuchProducts=Util.getRandom(1,4);
        int pause = Util.getRandom(500, 2000); //
        Util.sleep(pause);
        for (int product = 0; product < basketProduct.size(); product++) {
           basketProduct.add(howMuchProducts);
        }
        System.out.println(this + "The buyer put"+howMuchProducts+"product to the basket");
    }
}

