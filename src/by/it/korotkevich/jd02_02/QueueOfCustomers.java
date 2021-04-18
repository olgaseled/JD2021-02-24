package by.it.korotkevich.jd02_02;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueOfCustomers {

    private ConcurrentLinkedDeque<Customer> customers = new ConcurrentLinkedDeque<>();

    void add(Customer customer) {
        customers.addLast(customer);
    }

    Customer poll() {
        return customers.pollFirst();
    }

    int getQueueSize(){
        return customers.size();
    }
}
