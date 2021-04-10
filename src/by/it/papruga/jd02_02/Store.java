package by.it.papruga.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static void main(String[] args) {


        List<Thread> threads = new ArrayList<>(120);
        ListGoods listGoods = new ListGoods();

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }



        System.out.println("Store opened");
        int numberCustomer = 0;
        while (Manager.storeIsOpened()) {

            int count = Util.getRandom(2);

            for (int i = 0; i <= count && Manager.storeIsOpened(); i++) {

                Customer customer = new Customer(++numberCustomer);
                threads.add(customer);
                customer.start();
            }

            Util.sleep(1000);

        }
        for (Thread thread : threads) {

            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }

        System.out.println("Store closed");

    }


}
