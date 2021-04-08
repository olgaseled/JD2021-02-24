package by.it.kirichenko.jd02_02;

import java.util.*;

public class Basket {
    private int numberBuyer;
    private final Map<String, Double> listProductBuyer;

    Basket(int numberBuyer){
        this.numberBuyer = numberBuyer;
        listProductBuyer = new HashMap<String, Double>();
    }

    void addProductInBasket(Map<String, Double> product){
        for (Map.Entry<String, Double> entry : product.entrySet()) {
            listProductBuyer.put(entry.getKey(), entry.getValue());
        }
    }

    public String getBasket(){
        StringJoiner basketInString = new StringJoiner("; ", "[", "]");
        for (Map.Entry<String, Double> entry : listProductBuyer.entrySet()) {
            basketInString.add(entry.getKey() + " - " + entry.getValue() + " р.");
        }
        return basketInString.toString();
    }
}
