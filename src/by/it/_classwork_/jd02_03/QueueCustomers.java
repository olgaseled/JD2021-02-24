package by.it._classwork_.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueCustomers {

    private BlockingDeque<Customer> customers =
            new LinkedBlockingDeque<>(Config.Q_LEN);

    void add(Customer customer) {
        try {
            customers.putLast(customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Customer poll() {
        return customers.pollFirst();
    }
}
