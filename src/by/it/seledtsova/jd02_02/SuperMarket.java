package by.it.seledtsova.jd02_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SuperMarket extends BasketProduct {

    public static Map<String, Double> basketProduct = basketProduct();

      public static void main(String[] args) throws InterruptedException {
        int countBuyers = 0; // счетчик покупателей

        List<Buyer> buyers = new ArrayList<>(120);

        System.out.println("The store is opened");

        for (int waitTime = 0; waitTime < Configuration.FINAL_TIME; waitTime++) {
            int count = Util.getRandom(2); // каждую сек в магаз приходит от 0 до 2 покупателей
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++countBuyers);
                buyers.add(buyer);
                buyer.start(); // покупатель вошел в магазин

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
        System.out.println("The store  has closed");

    }
}


