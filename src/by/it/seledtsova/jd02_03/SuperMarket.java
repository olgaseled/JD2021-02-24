package by.it.seledtsova.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SuperMarket extends ProductList {




    public static void main(String[] args) throws InterruptedException {

        System.out.println("The store is opened");

        ExecutorService threadPool = Executors.newFixedThreadPool(5);// будет всего 5 одновременно работающих кассиров
        for (int i = 1; i <= 2; i++) { // запускаем от 1 до 2 кассиров
            Cashier cashier = new Cashier(i); // создали кассира нового
            threadPool.execute(cashier); // запустили кассира в пул потока

        }

        int countBuyers = 0; // счетчик покупателей

        while (Manager.marketIsOpened()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count && Manager.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++countBuyers);
                threadPool.execute(buyer); // запустили покупателейв пул потоков
            }
            Util.sleep(1000);
        }
        threadPool.shutdown();// остановили поток кассиров и покупателей
        while (true) { // пулы кассиров и покупателей должны перейти в состояние isTerminated, чтобы закрыть магазин
            try {
                if (threadPool.awaitTermination(10, TimeUnit.DAYS)) { // если мы дождались, что кассиры и покупатели закончили
                    break; // то наш бесконечный цикл закончится раньше 10 дней
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("The store  has closed"); // все потоки завершены и мазаг закрыт

    }
}


