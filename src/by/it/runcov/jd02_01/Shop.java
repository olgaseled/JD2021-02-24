package by.it.runcov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Shop {


    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>(120);
        ListGoods listGoods = new ListGoods();
        System.out.println("Shop opening");
        int numberBuyer = 0;
        for (int i = 0; i < Constant.Final_TIME; i++) {
            int count = Util.getRandom(2);
            for (int j = 0; j < count; j++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyers.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closing");
    }
}
