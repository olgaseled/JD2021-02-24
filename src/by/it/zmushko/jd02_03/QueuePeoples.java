package by.it.zmushko.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueuePeoples {
    public static final Object MONITOR_QUEUE = new Object();

    private BlockingDeque<Buyer> queuePeoples = new LinkedBlockingDeque<>(Constants.MAX_PEOPLE_IN_QUEUE);

    void addInQueue(Buyer people) {
        try {
            queuePeoples.putLast(people);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Buyer getOnePeople() {
        return queuePeoples.pollFirst();
    }

}
