package by.it.belazarovich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueOfBuyers {

    private BlockingDeque<Buyer> buyers =
            new LinkedBlockingDeque<>(Configuration.QUEUE_LENGTH);

    void add(Buyer buyer) {
        try {
            buyers.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Buyer poll() {
        return buyers.pollFirst();
    }
}
