package by.it.voitsekhovskiy.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Store {
    public static void main(String[] args) {
        int numBuyer = 0;

        System.out.println("Store opened");
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            executorService.execute(new Cashier(i));
        }
        executorService.shutdown();
        while (Manager.isOpenedStore()) {
            int random = Util.getRandom(2);
            for (int j = 0; j < random && Manager.isOpenedStore(); j++) {
                Buyer buyer = new Buyer((++numBuyer));
                if (numBuyer % 4 == 0) {
                    buyer.pensioner = true;
                }
                buyer.start();
            }
            Util.sleep(1000);
        }
        Cashier.wakeUpAllCashier();
        try {
            while (!executorService.awaitTermination(1, TimeUnit.HOURS)) {
                System.out.println("An hour has passed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store closed");
    }
}
