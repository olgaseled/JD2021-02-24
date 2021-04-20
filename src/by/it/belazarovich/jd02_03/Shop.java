package by.it.belazarovich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop {

    public static void main(String[] args) {

        QueueOfBuyers queueOfBuyers = new QueueOfBuyers();
        Manager manager = new Manager();
        Context context = new Context(queueOfBuyers, manager);
        ExecutorService threadCashier = Executors.newFixedThreadPool(5);


        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, context);
            threadCashier.execute(new Cashier(i,context));
        }


        System.out.println("Shop opened");
        int numberOfBuyers = 0;
        while (context.getManager().shopIsOpened()) {
            int randomNumber = Utils.getRandom(2);
            for (int i = 0; i < randomNumber && context.getManager().shopIsOpened(); i++) {
                Buyer buyer = new Buyer(++numberOfBuyers, context);
                buyer.start();
            }
            Utils.sleep(1000);
        }

        threadCashier.shutdown(); //больше потоков не будет
        for (; ; ) {
            try {
                if (threadCashier.awaitTermination(10, TimeUnit.DAYS)) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");
    }

}
