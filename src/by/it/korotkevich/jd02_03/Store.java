package by.it.korotkevich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Store {

    public static void main(String[] args) {
        GoodsList.fillPriceList();

        QueueOfCustomers queueOfCustomers = new QueueOfCustomers();
        Manager manager = new Manager();
        Basket basket = new Basket();
        Context context= new Context(queueOfCustomers, manager, basket);
        ExecutorService executorServiceForCashiers = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, context);
            executorServiceForCashiers.execute(new Cashier(i, context));
        }
        executorServiceForCashiers.shutdown();

        System.out.println("The store is opened.");
        int customerNumber = 0;
        while (context.getManager().storeIsOpened()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count && context.getManager().storeIsOpened(); i++) {
                Customer customer = new Customer(++customerNumber, context);
                customer.start();
            }
            Util.sleep(1000);
        }



        try {
            while (!executorServiceForCashiers.awaitTermination(10, TimeUnit.MINUTES)){
                System.out.println("oops");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Store closed.");
    }
}
