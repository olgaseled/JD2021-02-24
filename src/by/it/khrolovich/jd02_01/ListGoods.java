package by.it.khrolovich.jd02_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public  class ListGoods {
    //static HashMap<String,Double> price = new HashMap<>();
    //здесь static . Если нет, то в конструкторе заполняем//TODO
    static HashMap<Good,Double> price = new HashMap<>();
    /*{
        this.put(new Good("apple"),4.0);
        this.put(new Good("tomato"),5.0);
        this.put(new Good("cucumber"),3.0);
        this.put(new Good("egg"),2.0);

    };*/

    public ListGoods(){
        price.put(new Good("apple"),4.0);//price
        price.put(new Good("tomato"),5.0);
        price.put(new Good("cucumber"),3.0);
        price.put(new Good("egg"),2.0);
    }

    static double getPrice(Good name){
        return price.get(name);
    }

    public static Good randomGood(){
        ArrayList<Good> goods = new ArrayList<>(price.keySet());
        //перемешать или сгенерировать индекс
        Collections.shuffle(goods);
        return goods.get(0);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
