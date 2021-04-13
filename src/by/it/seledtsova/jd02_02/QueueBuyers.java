package by.it.seledtsova.jd02_02;


import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyers {

    private static final Object MONITOR_QUEUE = new Object(); //приватное поле monitor
    private static Deque<Buyer> buyers = new LinkedList<>(); //приватное поле очередь

    static void add(Buyer buyer) {
        synchronized (MONITOR_QUEUE) {
            buyers.addLast(buyer); // метод прин-ий покупателя , доваляет в конец нашего покупателя
        }
    }

    static Buyer poll() {
        synchronized (MONITOR_QUEUE) { // не один поток не пройдет, пока кто-то облаает монитором
            return buyers.pollFirst();// pollFirst возвращает null.  remove возвращает ошибки
        } // если есть покупатель, то обслуживает, а если нет , то ожидает
        }
    }

