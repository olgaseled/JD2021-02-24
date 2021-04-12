package by.it.korotkevich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueOfCustomers {

    static private BlockingDeque<Customer> customers = new LinkedBlockingDeque<>(Config.QUEUE_LENGTH);

    static void add(Customer customer) {
        try {
            customers.putLast(customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static Customer poll() {
        return customers.pollFirst();
    }
}
