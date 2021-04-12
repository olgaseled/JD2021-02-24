package by.it.papruga.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Store {

    public static void main(String[] args) {

        QueueCustomers queueCustomers = new QueueCustomers();
        Manager manager = new Manager();
        Context context = new Context(queueCustomers, manager);

        ListGoods listGoods = new ListGoods();
        ExecutorService threadCashier = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i, context);
            threadCashier.execute(cashier);
        }

        System.out.println("Store opened");
        int numberCustomer = 0;
        while (context.getManager().storeIsOpened()) {

            int count = Util.getRandom(2);

            for (int i = 0; i <= count && context.getManager().storeIsOpened(); i++) {

                Customer customer = new Customer(++numberCustomer, context);
                customer.start();
            }
            Util.sleep(1000);
        }

        threadCashier.shutdown();

        try {
            while (!threadCashier.awaitTermination(1, TimeUnit.HOURS)) {
                System.out.println("wow");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Store closed");

    }
}
