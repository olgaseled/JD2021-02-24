package by.it.runcov.jd02_01;

import java.util.*;

class ListGoods {

    static Map<Good, Double> price = new HashMap<>();

    public ListGoods(){ListGoods.fillPriseList();}

    static void fillPriseList() {
        price.put(new Good("bread"), 1.59);
        price.put(new Good("sugar"), 1.54);
        price.put(new Good("butter"), 3.50);
        price.put(new Good("salt"), 1.65);
    }

    static double getPrice(Good good) {
        return price.get(good);
    }

    static Good randomGood() {
        List<Good> goods = new ArrayList<>(price.keySet());
        Collections.shuffle(goods);
        return goods.get(0);
    }

}
