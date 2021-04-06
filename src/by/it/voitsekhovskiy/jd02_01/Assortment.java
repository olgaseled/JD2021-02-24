package by.it.voitsekhovskiy.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Assortment { // как грамотно заполнить hashmap???
    public static HashMap<String, Double> assortment = new HashMap<>();

    static void addElement() {
        assortment.put("Milk", 2.99);
        assortment.put("Bread", 3.99);
        assortment.put("Sugar", 1.99);
        assortment.put("Strawberries", 4.99);
    }

    static String getRandomElement() {
        Assortment.addElement();
        List<String> keys = new ArrayList<>(assortment.keySet());
        Integer random = Util.getRandom(assortment.size() - 1);
        return keys.get(random);
    }
}
