package by.it.korotkevich.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsList {

    private final static Object PRICE_LIST_MONITOR = 0;

    static volatile Map<Good, Double> priceList = new HashMap<>();
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

    static Map<Good, Double> getPriceList(){
        synchronized (PRICE_LIST_MONITOR){
            return priceList;
        }
    }

    static Good getAGood() {
        int random = Util.getRandom(0, goodsNameList.size()-1);
        return goodsNameList.get(random);
    }
}
