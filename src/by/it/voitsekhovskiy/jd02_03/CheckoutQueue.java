package by.it.voitsekhovskiy.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class CheckoutQueue {
    static BlockingDeque<Buyer> queueOfBuyers = new LinkedBlockingDeque<>(30);

    static void addBuyerInQueue(Buyer buyer) {
            Cashier.wakeUpCashier();
        try {
            queueOfBuyers.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer getFirstBuyerInQueue() {
            return queueOfBuyers.pollFirst();
    }
}
