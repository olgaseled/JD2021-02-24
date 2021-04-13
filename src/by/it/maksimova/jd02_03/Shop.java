package by.it.maksimova.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>(120);

        for (int i = 1; i < 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier, cashier.toString());
            threads.add(thread);
            thread.start();
        }

        System.out.println("Shop opened");
        int numberOfBuyers = 0;
        while (Manager.shopIsOpened()) {
            int randomNumber = Utils.getRandom(2);
            for (int i = 0; i < randomNumber && Manager.shopIsOpened(); i++) {
                Buyer buyer = new Buyer(++numberOfBuyers);
                threads.add(buyer);
                buyer.start();
            }
            Utils.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");
    }

}
