package by.it.korotkevich.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Store {


    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>(120);

        System.out.println("The store is opened.");

        int customerNumber = 0;
        for (int time = 0; time < Config.FINAL_TIME; time++) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count; i++) {
                Customer customer = new Customer(++customerNumber);
                customer.start();
            }
            Util.sleep(1000);
        }
        for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("The store is closed.");
    }
}
