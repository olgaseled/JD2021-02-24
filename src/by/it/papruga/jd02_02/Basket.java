package by.it.papruga.jd02_02;

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

    public double totalPrice()
    {
        double sum = 0;
        for (Good good : list) {
            sum = sum + ListGoods.getPrice(good);
        }
        return sum;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Good good : list) {

            sb.append("\n" + good + "\t" + ListGoods.getPrice(good) +"$");
        }

        sb.append("\n"+ "*****" + "\n"+"Total" + "\t" + totalPrice() + "$");
        return sb.toString();

    }
}
