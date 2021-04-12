package by.it.kirichenko.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyers {

    private static final Object MONITOR_QUEUE = new Object();

    private static Deque<Buyer> buyers = new LinkedList<>();

    static void add(Buyer buyer) {
        synchronized (MONITOR_QUEUE) {
            buyers.addLast(buyer);
        }
    }

    static Buyer poll() {
        synchronized (MONITOR_QUEUE) {
            return buyers.pollFirst();
        }
    }
}
