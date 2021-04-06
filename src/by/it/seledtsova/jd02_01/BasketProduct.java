package by.it.seledtsova.jd02_01;


import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
У каждого покупателя с корзиной (Basket) собирается набор от 1..4 товаров (Good)
 из фиксированного списка с ценой (рекомендуется hashmap, где товар –key,цена –value).
Время на каждую операцию от 0,5до 2 секунд, итог операции –в консоль.
 */

public class BasketProduct extends Thread implements IUseBasket  {
/*
public Buyer(int number) {
        super("Customer #" + number + " ");
    }
 */
    public BasketProduct() {



        HashMap<String, Integer> basketProduct = new LinkedHashMap<>(3);
        {
            basketProduct.put("Milk", 2);
            basketProduct.put("Bread", 1);
            basketProduct.put("Cheese", 3);
            basketProduct.put("Chocolate", 4);
        }

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

            int pause = Util.getRandom(500, 2000); //
            Util.sleep(pause);
        System.out.println(this+"The buyer put product to the basket");
        }
        /*
    @Override
    public Basket set(int index, T element) {
        T returnElements=elements[index];
        elements[index] = element;
        return returnElements;

    }

         */
}

