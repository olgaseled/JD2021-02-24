package by.it.papruga.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static void main(String[] args) {


        List<Customer> customers = new ArrayList<>(120);
        ListGoods listGoods = new ListGoods();
        System.out.println("Store opened");

        int numberCustomer = 0;

        for (int time = 0; time < Config.FINAL_TIME; time++) {

            int count = Util.getRandom(2);

            for (int i = 0; i < count; i++) {

                Customer customer = new Customer(++numberCustomer);
                customers.add(customer);
                customer.start();
            }

            Util.sleep(1000);

        }
        for (Customer customer : customers) {

            try {
                customer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }

        System.out.println("Store closed");

    }


}
