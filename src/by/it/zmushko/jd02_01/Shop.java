package by.it.zmushko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public static void main(String[] args) {
        System.out.println("Open shop");
        Products products = new Products(); //задать вопрос не забыть
        System.out.println(Products.products); //just test
        List<Buyer> listBuyers = new ArrayList();
        int numberOfPeopleWhoCome = 0;
        for (int openStoreTime = 0; openStoreTime < Constants.OPEN_STORE_TIME; openStoreTime++) {
            int wentToTheShop = Support.getRandom(2);
            for (int i = 0; i < wentToTheShop; i++) {
                Buyer buyer = new Buyer(++numberOfPeopleWhoCome);
                listBuyers.add(buyer);
                buyer.start();
            }
            Support.sleep(1000);
        }
        try {
            for (Buyer listBuyer : listBuyers) {
                listBuyer.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Close shop");


    }

}
