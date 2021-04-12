package by.it.korotkevich.jd02_03;

import java.util.ArrayList;
import java.util.List;
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

        while (true){
            try {
                if (!executorServiceForCashiers.awaitTermination(1, TimeUnit.HOURS)) break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("oops");
        }

        System.out.println("Store closed.");
    }
}
