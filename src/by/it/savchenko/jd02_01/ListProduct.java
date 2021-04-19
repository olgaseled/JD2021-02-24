package by.it.savchenko.jd02_01;

import java.util.*;

public class ListProduct {
    public static Map<String, Double> basket = new HashMap<>();

    public ListProduct() {
        basket.put("Молоко", 2.5);
        basket.put("Хлеб", 1.3);
        basket.put("Чай", 1.25);
        basket.put("Шоколад", 3.4);
    }

    public static String getRandomProduct() {
        List<String> keys = new ArrayList<>(basket.keySet());
        Integer random = Util.getRandom(basket.size() - 1);
        return keys.get(random);
    }
}