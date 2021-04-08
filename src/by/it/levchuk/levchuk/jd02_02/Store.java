package by.it.levchuk.levchuk.jd02_02;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayList;
import java.util.List;

class Store {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>(Сoefficients.VISIT_TIME);
        for (int i = 0; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier, cashier.toString());
            threads.add(thread);
            thread.start();
        }
        System.out.println("МАГАЗИН ОТКРЫЛСЯ");
        int numberBuyer = 0;
        while (SeniorCashier.storeIsOpened()) {
            int count = Tools.getRandom(2);
            for (int i = 0; i < count && SeniorCashier.storeIsOpened(); i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                threads.add(buyer);
                buyer.start();
            }
            Tools.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("МАГАЗИН ЗАКРЫЛСЯ");
    }
}
