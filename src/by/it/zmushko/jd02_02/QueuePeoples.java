package by.it.zmushko.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueuePeoples {
    public static final Object MONITOR_QUEUE = new Object();

    private static Deque<Buyer> queuePeoples = new LinkedList<>();

    static void addInQueue(Buyer people) {
        synchronized (MONITOR_QUEUE) {
            queuePeoples.addLast(people);
        }
    }

    static Buyer getOnePeople() {
        synchronized (MONITOR_QUEUE) {
            return queuePeoples.pollFirst();
        }
    }

}
