package by.it.zmushko.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop {

    public static void main(String[] args) {
        Products products = new Products();
        QueuePeoples queuePeoples = new QueuePeoples();
        Manager manager = new Manager();
        Contex contex = new Contex(queuePeoples, manager);
        ExecutorService executorServiceCashier = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 3; i++) {
            Cashier cashier = new Cashier(i, contex);
            executorServiceCashier.execute(cashier);
        }
        executorServiceCashier.shutdown();
        System.out.println("Open shop");
        System.out.println(Products.products); //just test

        List<Thread> listBuyers = new ArrayList<>();

        int numberOfPeopleWhoCome = 0;
        while (contex.getManager().storeOpen()) {
            int wentToTheShop = Support.getRandom(2);
            for (int i = 0; i < wentToTheShop && contex.getManager().storeOpen(); i++) {
                Buyer buyer = new Buyer(++numberOfPeopleWhoCome, contex);
                buyer.start();
            }
            Support.sleep(1000);
        }
        try {
            while (!executorServiceCashier.awaitTermination(3, TimeUnit.MINUTES)){
                System.out.println("something wrong");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Close shop");
    }

}
