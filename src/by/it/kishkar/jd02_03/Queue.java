package by.it.kishkar.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Queue {

    private final BlockingDeque<Buyer> deque;

    public Queue(int maxLength) {
        deque=new LinkedBlockingDeque<>(maxLength);
    }

    void add(Buyer buyer) {
        try {
            deque.putLast(buyer);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

     Buyer poll() {
        try {
            return deque.pollFirst(100, TimeUnit.MICROSECONDS);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Ошибка Error");
     }
}
