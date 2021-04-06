package by.it.dudko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        System.out.println("Store is open");
        int customerId = 0;
        for (int second = 0; second < Config.MEASURE_TIME; second++) {
            int newCustomers = CustomerUtil.getRandom(2);
            for (int i = 0; i < newCustomers; i++) {
                Customer customer = new Customer(++customerId);
                customers.add(customer);
                customer.start();
            }
            CustomerUtil.sleep(1000);
        }

        for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Store is closed");
    }
}
