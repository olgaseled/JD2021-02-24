package by.it.korotkevich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueOfCustomers {

    private BlockingDeque<Customer> customers = new LinkedBlockingDeque<>(Config.QUEUE_LENGTH);

    void add(Customer customer) {
        try {
            customers.putLast(customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    Customer poll() {
        return customers.pollFirst();
    }

    int getQueueSize(){
        return customers.size();
    }
}
