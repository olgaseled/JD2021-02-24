package by.it.levchuk.levchuk.jd02_01;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.HashMap;

public class PriceList {

    HashMap<String,Double> priceList = new HashMap<>();

    public void setPriceList(HashMap<String, Double> priceList) {

        priceList.put("Хлеб", 2.15);
        priceList.put("Молоко", 2.15);
        priceList.put("Масло", 2.15);
        priceList.put("Мясо", 2.15);
        priceList.put("Овощи", 2.15);
        priceList.put("Фрукты", 2.15);
        priceList.put("Напитки", 2.15);
        priceList.put("Алкоголь", 2.15);
        priceList.put("Сигареты", 2.15);

        this.priceList = priceList;
    }
}
