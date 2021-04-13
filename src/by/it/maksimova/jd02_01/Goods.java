package by.it.maksimova.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Goods extends Thread {

    static Map<String, Double> listOfGoods = new HashMap<>();

    public static void getListOfGoods() {
        listOfGoods.put("Milk", 1.5);
        listOfGoods.put("Bread", 2.6);
        listOfGoods.put("Water", 1.1);
        listOfGoods.put("Cream", 3.4);
        listOfGoods.put("Cheese", 2.3);
    }



}
