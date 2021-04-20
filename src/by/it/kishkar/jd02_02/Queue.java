package by.it.kishkar.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class Queue {
    private static final Object MONITOR_QUEUE = new Object();

    private static Deque<Buyer> customers = new LinkedList<>();

    static void add(Buyer customer) {
        synchronized (MONITOR_QUEUE) {
            customers.addLast(customer);
        }
    }

    static Buyer poll() {
        synchronized (MONITOR_QUEUE) {
            return customers.pollFirst();
        }
    }
}
