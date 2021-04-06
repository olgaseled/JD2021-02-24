package by.it.levchuk.levchuk.jd02_01;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.HashMap;

public class PriceList {

    HashMap<String,Double> priceList = new HashMap<>();

    public void setPriceList(HashMap<String, Double> priceList) {
        priceList.put("Хлеб", 2.15);

        this.priceList = priceList;
    }
}
