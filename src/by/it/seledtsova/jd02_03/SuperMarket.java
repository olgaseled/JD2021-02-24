package by.it.seledtsova.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SuperMarket extends ProductList {

    public static ProductList productList;


      public static void main(String[] args) throws InterruptedException {

          System.out.println("The store is opened");

          ExecutorService threadCashier =Executors.newFixedThreadPool(5);// будет всего 5 одновременно работающих кассиров
          for (int i = 1; i <=2 ; i++) { // запускаем от 1 до 2 кассиров
              Cashier cashier=new Cashier(i); // создали кассира нового
              threadCashier.execute(cashier); // запустили кассира в пул потока

            }
          threadCashier.shutdown();// остановили поток кассиров


          int countBuyers = 0; // счетчик покупателей

          while (Manager.marketIsOpened()) {
              int count = Util.getRandom(2);
              for (int i = 0; i < count && Manager.marketIsOpened(); i++) {
                  Buyer buyer = new Buyer(++countBuyers);
                  buyer.start();
              }
            Util.sleep(1000);
              }
          while (true){ // пул кассиров должен перейти в состояние isTerminated, чтобы закрыть магазин
              try {
        if (threadCashier.awaitTermination(10, TimeUnit.DAYS)) { // если мы дождались ( прошло менее 10 дней) , что кассиры закончили
            break; // то наш бесконечный цикл закончится раньше 10 дней
          }
              } catch (InterruptedException e) {
                throw new RuntimeException  (e);
              }
          }
        System.out.println("The store  has closed"); // все потоки завершены и мазаг закрыт

    }
}


