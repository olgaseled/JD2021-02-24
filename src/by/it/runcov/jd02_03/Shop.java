package by.it.runcov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Shop {


    public static void main(String[] args) {
        QueueBuyers queueBuyers = new QueueBuyers();
        Manager manager = new Manager();
        Context context = new Context(queueBuyers, manager);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, context);
            executorService.execute(new Cashier(i, context));
        }
        executorService.shutdown();
        System.out.println("Shop opening");
        int numberBuyer = 0;
        while (context.getManager().shopIsOpened()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count && context.getManager().shopIsOpened(); i++) {
                Buyer buyer = new Buyer(++numberBuyer, context);
                buyer.start();
            }
            Util.sleep(1000);
        }
        try {
            while (true) {
                if (executorService.awaitTermination(1, TimeUnit.MINUTES))
                    break;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Shop closing");
    }
}
