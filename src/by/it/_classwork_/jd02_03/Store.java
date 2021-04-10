package by.it._classwork_.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Store {

    public static void main(String[] args) {
        new Store().go(args);
        new Store().go(args);
        new Store().go(args);
        new Store().go(args);
    }


    public void go(String[] args) {

        QueueCustomers queueCustomers = new QueueCustomers();
        Manager manager = new Manager();
        Context context = new Context(queueCustomers, manager);
        ExecutorService executorServiceCashiers = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, context);
            executorServiceCashiers.execute(new Cashier(i,context));
        }
        executorServiceCashiers.shutdown();
        System.out.println("Store opened");
        int numberCustomer = 0;
        while (context.getManager().storeIsOpened()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count && context.getManager().storeIsOpened(); i++) {
                Customer customer = new Customer(++numberCustomer, context);
                customer.start();
            }
            Util.sleep(1000);
        }
        try {
            while (!executorServiceCashiers.awaitTermination(1, TimeUnit.HOURS)) {
                System.out.println("wow");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store closed");
    }
}
