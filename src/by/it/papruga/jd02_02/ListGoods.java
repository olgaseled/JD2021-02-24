package by.it.papruga.jd02_02;

import java.util.*;

public class ListGoods {

    static Map<Good, Double> map = new HashMap<>();

    public ListGoods() {
        ListGoods.fillPriseList();
    }

    static void fillPriseList() {
        map.put(new Good("Bread"), 1.1);
        map.put(new Good("Milk"), 2.3);
        map.put(new Good("Sugar"), 1.5);
        map.put(new Good("Salt"), 0.5);
    }


    static double getPrice(Good good) {
        return map.get(good);
    }

    static Good randomGood() {

        List<Good> goods = new ArrayList<>(map.keySet());

        Collections.shuffle(goods);

        return goods.get(0);

    }


}
