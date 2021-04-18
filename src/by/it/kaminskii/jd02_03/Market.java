package by.it.kaminskii.jd02_03;/* created by Kaminskii Ivan
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Market {
    public static void main(String[] args) {
        System.out.println("Market opened");
        BuyerQueue buyerQueue = new BuyerQueue(30);
        Semaphore sem = new Semaphore(20);

        ExecutorService threadPoolCasheir = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, buyerQueue);
            threadPoolCasheir.execute(cashier);
        }
        threadPoolCasheir.shutdown();

        int numberBuyer = 0;
        ExecutorService threadPoolBuyers = Executors.newFixedThreadPool(50);
        while (Manager.marketIsOpened()) {
            int buyers = Helper.randomValue(2);
            for (int j = 0; j < buyers && Manager.marketIsOpened(); j++) {
                Buyer buyer = new Buyer(sem, ++numberBuyer, buyerQueue);
                threadPoolBuyers.execute(buyer);
            }
            Helper.sleep(1000);
        }
        threadPoolBuyers.shutdown();

        while (true) {
            try {
                if (threadPoolCasheir.awaitTermination(1, TimeUnit.HOURS) &&
                        threadPoolBuyers.awaitTermination(1, TimeUnit.HOURS)) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");

    }
}