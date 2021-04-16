package by.it.kaminskii.jd02_03;/* created by Kaminskii Ivan
 */

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class BuyerQueue {

    private BlockingDeque<Buyer> buyers;

    public BuyerQueue(int maxLength) {
        buyers = new LinkedBlockingDeque<>(maxLength);
    }

    void add(Buyer buyer) {
        try {
            buyers.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Buyer pull() {
        try {
            return buyers.pollFirst(100, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("просто ошибка просто пока");
    }
}


//    private static final Object MONITOR_QUEUE = new Object();
//
//    private static Deque<Buyer> buyers = new LinkedList<>();
//
//    static void add(Buyer buyer) {
//        synchronized (MONITOR_QUEUE) {
//            buyers.addLast(buyer);
//        }
//    }
//
//    static Buyer pull() {
//        synchronized (MONITOR_QUEUE) {
//            return buyers.pollFirst();
//        }
//    }
//}

