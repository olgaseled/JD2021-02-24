package by.it.levchuk.levchuk.jd02_01;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.HashMap;

public class PriceList {
    HashMap<String,Double> priceList = new HashMap<>();

    public void setPriceList(HashMap<String, Double> priceList) {

        priceList.put("Хлеб", 2.15);
        priceList.put("Молоко", 1.20);
        priceList.put("Масло", 3.40);
        priceList.put("Мясо", 11.20);
        priceList.put("Овощи", 8.15);
        priceList.put("Фрукты", 6.50);
        priceList.put("Напитки", 3.40);
        priceList.put("Алкоголь", 30.60);
        priceList.put("Сигареты", 3.40);

        this.priceList = priceList;
    }
}
