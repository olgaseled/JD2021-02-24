package by.it.khrolovich.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;

public  class PriceList {
    //static HashMap<String,Double> price = new HashMap<>();
    //здесь static . Если нет, то в конструкторе заполняем//TODO
    private static HashMap<Good,Double> price = new HashMap<>(){
        this.put(new Good("apple",4.0)));
    };

    public PriceList(){
        price.put("apple",4.0);
        price.put("tomato",5.0);
        price.put("cucumber",3.0);
        price.put("egg",2.0);
    }

    static double getPrice(Good name){
        return price.get(good);
    }

    static Good randomGood(){
        ArrayList<PriceList> goods = new ArrayList<>(price.keySet());
        //сгенерировать индекс! или перетасовать shuffel
        return goods.get(1);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
