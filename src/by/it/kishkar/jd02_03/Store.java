package by.it.kishkar.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Store {
    public static void main(String[] args) {
        System.out.println("Start");

        Queue queue=new Queue(30);


        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, queue);
            threadPool.execute(cashier);
        }


        int numberCustomer = 0;
        while (Manager.storeIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Manager.storeIsOpened(); i++) {
                Buyer customer = new Buyer(++numberCustomer, queue);
                customer.start();
            }
            Helper.sleep(1000);
        }
        threadPool.shutdown();

        for (; ;)  {
            try {
                if (threadPool.awaitTermination(10, TimeUnit.SECONDS)){
                    break;
                }
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }


        }
        System.out.println("Close");
    }
}


 // for (; ;) {} - endless cycle
// if need swap to: while (true) {}