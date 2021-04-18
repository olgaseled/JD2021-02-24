package by.it.korotkevich.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueOfCustomers {
    private static final Object MONITOR_QUEUE = new Object();

    private static Deque<Customer> customers = new LinkedList<>();

    static void add(Customer customer) {
        synchronized (MONITOR_QUEUE) {
            customers.addLast(customer);
        }
    }

    static Customer poll() {
        synchronized (MONITOR_QUEUE) {
            return customers.pollFirst();
        }
    }
}
