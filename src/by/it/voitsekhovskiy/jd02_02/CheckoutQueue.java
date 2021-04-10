package by.it.voitsekhovskiy.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class CheckoutQueue {
    final static Object monitorQueue = new Object();

    static Deque<Buyer> queueOfBuyers = new LinkedList<>();

    static void addBuyerInQueue(Buyer buyer) {
        wakeUpCashier();
        synchronized (monitorQueue) {
            queueOfBuyers.addLast(buyer);
        }
    }

    static Buyer getFirstBuyerInQueue() {
        synchronized (monitorQueue) {
            return queueOfBuyers.pollFirst();
        }
    }

    static void wakeUpCashier() {
        synchronized (Cashier.getCashierMonitor()) {
            if(queueOfBuyers.size() % 5 == 0) {
                Cashier.getCashierMonitor().notify();
            }
        }
    }
}
