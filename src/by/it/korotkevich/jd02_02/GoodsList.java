package by.it.korotkevich.jd02_02;

import java.util.*;

public class GoodsList {

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
        int random = Util.getRandom(0, goodsNameList.size()-1);
        return goodsNameList.get(random);
    }
}
