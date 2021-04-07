package by.it.khrolovich.jd02_01;

import by.it.khrolovich.jd02_02.PriceList;

import java.util.ArrayList;
import java.util.List;

public class Basket {


    private List<Good> list = new ArrayList<>();
    void put(Good good)
    { list.add(good);

    }

    void showContent(){
        for (Good good : list) {
            System.out.println(good+" price"+ PriceList.get);
        }
    }

}
