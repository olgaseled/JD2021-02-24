package by.it.khrolovich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class QueueCustomer {

    private BlockingDeque<Customer> customers;//blocking queue

    public QueueCustomer(int maxCapacity) {
        customers=  new LinkedBlockingDeque<>(maxCapacity);
    }

    void add(Customer customer) {
            customers.addLast(customer);
    }

    Customer poll() {
        try {
            return customers.poll(100, TimeUnit.MICROSECONDS);//wait before poll from queue
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
