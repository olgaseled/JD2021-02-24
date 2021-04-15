package by.it.maksimova.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfGoods {
    static Map<String, Double> listOfGoods = new HashMap<>();

    public static void addGood() {
        listOfGoods.put("Milk", 1.5);
        listOfGoods.put("Bread", 2.6);
        listOfGoods.put("Water", 1.1);
        listOfGoods.put("Cream", 3.4);
        listOfGoods.put("Cheese", 2.3);
    }

    static String getRandomGood() {
        ListOfGoods.addGood();
        List<String> keys = new ArrayList<>(listOfGoods.keySet());
        int random = Utils.getRandom(listOfGoods.size() - 1);
        return keys.get(random);
    }

}
