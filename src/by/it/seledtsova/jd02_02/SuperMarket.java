package by.it.seledtsova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class SuperMarket extends ProductList {

    public static ProductList productList;


      public static void main(String[] args) throws InterruptedException {
          List <Thread> threads=new ArrayList<>(120); // кассиры и покупатели стали в одном листе

          for (int i = 1; i <=2 ; i++) { // запускаем от 1 до 2 кассиров
              Cashier cashier=new Cashier(i); // создали кассира нового
              Thread thread=new Thread(cashier, cashier.toString()); // положили нашего кассива в поток
              threads.add(thread);
              thread.start(); // запустили поток
            }

        System.out.println("The store is opened");

          int countBuyers = 0; // счетчик покупателей

          while (Manager.storeIsOpened()) {
              int count = Util.getRandom(2);
              for (int i = 0; i < count && Manager.storeIsOpened(); i++) {
                  Buyer buyer = new Buyer(++countBuyers);
                  threads.add(buyer);
                  buyer.start();
              }
            Util.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("The store  has closed"); // все потоки завершены

    }
}


