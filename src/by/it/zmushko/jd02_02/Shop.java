package by.it.zmushko.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public static void main(String[] args) {
        System.out.println("Open shop");
        Products products = new Products(); //задать вопрос не забыть
        System.out.println(Products.products); //just test

        List<Thread> listBuyers = new ArrayList<>();

        for (int i = 1; i < 3; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier, cashier.toString());
            listBuyers.add(thread);
            thread.start();
        }

        int numberOfPeopleWhoCome = 0;
        while (Manager.storeOpen()) {
            int wentToTheShop = Support.getRandom(2);
            for (int i = 0; i < wentToTheShop && Manager.storeOpen(); i++) {
                Buyer buyer = new Buyer(++numberOfPeopleWhoCome);
                listBuyers.add(buyer);
                buyer.start();
            }
            Support.sleep(1000);
        }
        for (Thread listBuyer : listBuyers) {
            try {
                listBuyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Close shop");
    }

}
