package by.it.papruga.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueCustomers {


    private final BlockingDeque<Customer> customers =
            new LinkedBlockingDeque<>(Config.QUEUE_LEN);

    void add(Customer customer){
        try {
            customers.putLast(customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Customer pull(){ return customers.pollFirst(); }

    public int getCustomersSize() {
        return customers.size();
    }
}
