package by.it.korotkevich.jd02_01;

import java.util.*;

public class GoodsList {
    //рандомный товар можно получить через shuffle Листа с товарами (просто взять первый элемент)
    //карту товаров можно сделать через анонимный класс

    static Map<Good, Double> priceList = new HashMap<>();
    static List<Good> goodsNameList = null;

    static void fillPriceList() {
        priceList.put(new Good("Apple"), 1.2);
        priceList.put(new Good("Banana"), 1.8);
        priceList.put(new Good("Chicken"), 6.1);
        priceList.put(new Good("Cake"), 8.5);
        priceList.put(new Good("Milk"), 1.3);
        priceList.put(new Good("Fish"), 4.4);
        goodsNameList = new ArrayList<>(priceList.keySet());
    }


    static Good getAGood() {
        Collections.shuffle(goodsNameList);
        return goodsNameList.get(0);
    }
}
