package by.it.papruga.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Store {

    public static void main(String[] args) {

        QueueCustomers queueCustomers = new QueueCustomers();
        QueueCashiers queueCashiers = new QueueCashiers();
        Manager manager = new Manager();
        ListGoods listGoods = new ListGoods();
        Context context = new Context(queueCustomers, queueCashiers, manager);

        ExecutorService threadCashier = Executors.newFixedThreadPool(Config.CASHIERS_RESERVE);

        for (int i = 1; i <= Config.CASHIERS_RESERVE; i++) {
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
            while (!threadCashier.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("wow");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Store closed");

    }
}
