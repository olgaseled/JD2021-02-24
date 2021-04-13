package by.it.runcov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Basket {

    private final List<Good> list = new ArrayList<>();

    void put(Good good) {
        list.add(good);
    }

    void showContent() {
        for (Good good : list) {
            System.out.println(good + "price" + ListGoods.getPrice(good));
        }
    }

}
