package by.it.papruga.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueCustomers {


    private static final Deque<Customer> customers = new LinkedList<>();


    static synchronized void add(Customer customer){

        customers.addLast(customer);
        Manager.queueIn();
    }

    static synchronized Customer pull(){

        return customers.pollFirst();
    }


    public static int getCustomersSize() {
        return customers.size();
    }
}
