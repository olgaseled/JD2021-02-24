package by.it.runcov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {

    private BlockingDeque<Buyer> buyers =
            new LinkedBlockingDeque<>(Constant.QUEUE_LEN);


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

