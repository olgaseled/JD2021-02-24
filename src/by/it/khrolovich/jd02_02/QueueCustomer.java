package by.it.khrolovich.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueCustomer {

    private static final Object MONITOR_QUEUE = new Object();
    private static Deque<Customer> customers = new LinkedList<>();//очередь не потокобезопасна!

    static void add(Customer customer){
        synchronized (MONITOR_QUEUE){
            customers.addLast(customer);
        }
    }

    static Customer poll(){
        synchronized (MONITOR_QUEUE){
            return  customers.poll();
        }
    }

}
