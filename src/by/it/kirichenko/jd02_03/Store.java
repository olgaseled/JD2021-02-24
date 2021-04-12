package by.it.kirichenko.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Store {

    public static void main(String[] args) {
        putProductsInWindow();

        List<Thread> threads = new ArrayList<>(120);

        ExecutorService executorServiceCashiers = Executors.newFixedThreadPool(5);


        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            executorServiceCashiers.execute(cashier);
        }
        executorServiceCashiers.shutdown();

        System.out.println("Store opened.");
        int numberBuyer = 0;
        while (Manager.storeIsOpened()) {
//            for (int time = 0; time < 2; time++) {
            for (int time = 0; time < Config.FINAL_TIME; time++) {
//                int count = 2;
                int count = Util.getRandom(2);
                for (int i = 0; i < count && Manager.storeIsOpened(); i++) {
                    Buyer buyer = new Buyer(++numberBuyer);
                    threads.add(buyer);
                    buyer.start();
                }
                Util.sleep(1000);
            }
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            while(!executorServiceCashiers.awaitTermination(1, TimeUnit.HOURS)){}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store closed.");
    }

    private static void putProductsInWindow() {
        StoreWindow.addProduct("ball", 50.00);
        StoreWindow.addProduct("kick scooter", 500.00);
        StoreWindow.addProduct("boxing gloves", 500.00);
        StoreWindow.addProduct("bike", 2000.00);
        StoreWindow.addProduct("tennis ball", 5.00);
    }
}
