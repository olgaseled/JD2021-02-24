package by.it.dudko.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueCustomers {

    private static final BlockingDeque<Customer> customers =
            new LinkedBlockingDeque<>(Config.Q_LEN);

    static void add(Customer customer) {
        try {
            customers.putLast(customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Customer poll() {
        return customers.pollFirst();
    }
}
