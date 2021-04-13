package by.it.kirichenko.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {

    private final Object MONITOR_QUEUE = new Object();

    private static BlockingDeque<Buyer> buyers = new LinkedBlockingDeque<>(Config.QUEUE_LENGTH);

    static void add(Buyer buyer) {
        try {
            buyers.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer poll() {
        return buyers.pollFirst();
    }
}
