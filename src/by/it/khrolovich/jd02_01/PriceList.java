package by.it.khrolovich.jd02_01;

import java.util.HashMap;

public  class PriceList {
    static HashMap<String,Double> price = new HashMap<>();

    public PriceList(){
        price.put("apple",4.0);
        price.put("tomato",5.0);
        price.put("cucumber",3.0);
        price.put("egg",2.0);
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
