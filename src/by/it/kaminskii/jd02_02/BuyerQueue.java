package by.it.kaminskii.jd02_02;/* created by Kaminskii Ivan
 */

import java.util.Deque;
import java.util.LinkedList;

public class BuyerQueue {
    private static final Object MONITOR_QUEUE = new Object();
    public static Deque<Buyer> buyerQueue = new LinkedList<>();

    public static void buyerAdd(Buyer buyer){
        synchronized (MONITOR_QUEUE) {
            buyerQueue.addLast(buyer);
        }
    }


    static Buyer buyerPull() {
        synchronized (MONITOR_QUEUE) {
            return buyerQueue.pollFirst();
        }
    }
}
