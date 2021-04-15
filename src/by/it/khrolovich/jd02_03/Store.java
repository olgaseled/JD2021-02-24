package by.it.khrolovich.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Store {

    public static ListGoods priceList;


    public static void main(String[] args) {
        priceList = new ListGoods();

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }

        System.out.println("Store opened");
        int numberCustomer = 0;
        while (Manager.storeIsOpened()) {
            for (int i = 0; i < Config.FINAL_TIME; i++) {

                int count = Util.getRandom(0, 2);
                for (int j = 0; j < count && Manager.storeIsOpened(); j++) {
                    numberCustomer++;
                    Customer customer = new Customer(numberCustomer);
                    threadPool.execute(customer);
                }
                Util.Sleep(1000);
            }
        }
        threadPool.shutdown();//block another threads
        while(true){
            try {
                if(threadPool.awaitTermination(10, TimeUnit.DAYS)){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Store closed");
    }
}
