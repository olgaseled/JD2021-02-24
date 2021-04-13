package by.it.khrolovich.jd02_02;

import by.it.khrolovich.jd02_01.ListGoods;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static ListGoods priceList;


    public static void main(String[] args) {
        priceList = new ListGoods();
        //List<Customer> customers = new ArrayList<>(120);//список покупателей
        List<Thread> threads = new ArrayList<>(120);//список покупателей

        for (int i=1;i<=2;i++){
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier, cashier.toString());
            threads.add(thread);//TODO
            thread.start();
        }

        System.out.println("Store opened");
        int numberCustomer = 0;
        while(Manager.storeIsOpened()) {
            for (int i = 0; i < Config.FINAL_TIME; i++) {

                int count = Util.getRandom(0, 2);
                for (int j = 0; j < count && Manager.storeIsOpened(); j++) {//если 99 и добавилось 2
                    // если нет проверки Manager.storeIsOpened() , то проскакивает больше покупателей
                    numberCustomer++;
                    Customer customer = new Customer(numberCustomer);
                    //customers.add(customer);
                    threads.add(customer);
                    customer.start();
                }
                Util.Sleep(1000);
            }
        }
        /*for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                throw new RuntimeException();
            }
        }*/

         for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("Store closed");
    }
}
