package by.it.maksimova.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class BuyersInQueue {
    private static final Object MONITOR_QUEUE = new Object();

    private static Deque<Buyer> buyers = new LinkedList<>();

    static void add(Buyer customer) {
        synchronized (MONITOR_QUEUE) {
            buyers.addLast(customer);
        }
    }

    static Buyer poll() {
        synchronized (MONITOR_QUEUE) {
            return buyers.pollFirst();
        }
    }
}
