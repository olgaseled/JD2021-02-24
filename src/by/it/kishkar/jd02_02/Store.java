package by.it.kishkar.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Store {
    public static void main(String[] args) {
        System.out.println("Start");
        List<Thread> threads = new ArrayList<>(120);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier, cashier.toString());
            threads.add(thread);
            thread.start();
        }
        int numberCustomer = 0;
        while (Manager.storeIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Manager.storeIsOpened(); i++) {
                Buyer customer = new Buyer(++numberCustomer);
                threads.add(customer);
                customer.start();
            }
            Helper.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Close");
    }
}