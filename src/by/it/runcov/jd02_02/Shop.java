package by.it.runcov.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Shop {


    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>(120);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier, cashier.toString());
            threads.add(thread);
            thread.start();
        }
        System.out.println("Shop opening");
        int numberBuyer = 0;
        while (Manager.shopIsOpened()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count && Manager.shopIsOpened(); i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                threads.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closing");
    }
}
