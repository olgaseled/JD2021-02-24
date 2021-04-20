package by.it.levchuk.levchuk.jd02_02;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {

    private final BlockingDeque<Buyer> buyers =
            new LinkedBlockingDeque<>(Сoefficients.QUEUE_LENGTH);

    void add(Buyer buyer){
        try {
            buyers.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Buyer pull(){ return buyers.pollFirst(); }

    public int getCustomersSize() {
        return buyers.size();
    }
}
