package by.it.khrolovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Good> list = new ArrayList<>();

    void put(Good good) {
        list.add(good);
    }

    double showContent() {
        double sumOfBill = 0;
        for (Good good : list) {
            System.out.println(good + " price " + ListGoods.getPrice(good));
            sumOfBill += ListGoods.getPrice(good);
        }
        return sumOfBill;
    }

}
