package by.it.levchuk.levchuk.jd02_02;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceList {

    private final static Object PRICE_LIST_MONITOR = 0;
    static volatile Map<Good, Double> priceList = new HashMap<>();
    static List<Good> goodsList = null;

    public static void setPriceList() {
        priceList.put(new Good("Хлеб"), 2.15);
        priceList.put(new Good("Молоко"), 1.20);
        priceList.put(new Good("Масло"), 3.40);
        priceList.put(new Good("Мясо"), 11.20);
        priceList.put(new Good("Овощи"), 8.15);
        priceList.put(new Good("Фрукты"), 6.50);
        priceList.put(new Good("Напитки"), 3.40);
        priceList.put(new Good("Алкоголь"), 30.60);
        priceList.put(new Good("Сигареты"), 3.40);
        goodsList=new ArrayList<>(priceList.keySet());
    }
    static Good getAGood() {
        int random = Tools.getRandom(0, goodsList.size()-1);
        return goodsList.get(random);
    }

    static Map<Good, Double> getPriceList(){
        synchronized (PRICE_LIST_MONITOR){
            return priceList;
        }
    }
}
