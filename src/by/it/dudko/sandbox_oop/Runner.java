package by.it.dudko.sandbox_oop;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        Store<String, Double> grocery = new GroceryStore("Fresh");
        grocery.setCurrency(Currency.EUR);
        Map<String, Double> goods = new HashMap<>();
        goods.put("French cheese", 3.55);
        goods.put("Holland cheese", 2.8);
        goods.put("Russian cheese", 1.2);
        try {
            grocery.assignGoods(goods);
            grocery.addProduct("Milk", 0.6);
            grocery.sales(10);
            grocery.printGoods();
        } catch (StoreException e) {
            throw new RuntimeException(e);
        }
    }
}
