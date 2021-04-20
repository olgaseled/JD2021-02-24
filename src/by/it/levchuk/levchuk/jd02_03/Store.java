package by.it.levchuk.levchuk.jd02_03;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Store {

    public static void main(String[] args) {
        PriceList.setPriceList();

        QueueBuyers queueBuyers = new QueueBuyers();
        SeniorCashier seniorCashier = new SeniorCashier();
        Basket basket = new Basket();
        Conditions conditions= new Conditions(queueBuyers, seniorCashier, basket);
        ExecutorService executorServiceForCashiers = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, conditions);
            executorServiceForCashiers.execute(new Cashier(i, conditions));
        }
        executorServiceForCashiers.shutdown();

        System.out.println("МАГАЗИН ОТКРЫТ");
        int customerNumber = 0;
        while (SeniorCashier.storeIsOpened()) {
            int count = Tools.getRandom(2);
            for (int i = 0; i < count && SeniorCashier.storeIsOpened(); i++) {
                Buyer customer = new Buyer(++customerNumber, conditions);
                customer.start();
            }
            Tools.sleep(1000);
        }



        try {
            while (!executorServiceForCashiers.awaitTermination(10, TimeUnit.MINUTES)){
                System.out.println("Галя, отмена");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("МАГАЗИН ЗАКРЫТ");
    }
}
