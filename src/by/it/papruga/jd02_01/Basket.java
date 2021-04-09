package by.it.papruga.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Basket {


    private List<Good> list = new ArrayList<>();

    void put(Good good) {

        list.add(good);

    }

    public List<Good> getList() {
        return list;
    }


    public void showContent() {

        for (Good good : list) {

            System.out.println(good + " price: " + ListGoods.getPrice(good));

        }

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Good good : list) {

            sb.append("\n" + good + "\t" + " price: " + ListGoods.getPrice(good));
        }
        return sb.toString();

    }
}
