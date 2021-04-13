package by.it.seledtsova.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class QueueBuyers {

 //   private static final Object MONITOR_QUEUE = new Object(); //приватное поле monitor

    public QueueBuyers (int maxLength) { // тк количество фиксированное ( <30))
    buyersDeque= new LinkedBlockingDeque<>(maxLength); // заменили очередь на потокобезопасную и проинициализировали ее
}
    private final BlockingDeque<Buyer> buyersDeque; //убрали статик

    void add(Buyer buyer) { // делаем методы покотобезопасными
        try {
            buyersDeque.putLast(buyer); // покупатель сам себя добавляет в очередь или заблокируется
        } catch (InterruptedException e) { // try/catch  тк покупатель может заблокироваться
            e.printStackTrace();
        }
    }
         Buyer poll() {
         try { // в кассире нужно будет проверять , не вернули ли нам null
             return buyersDeque.pollFirst(100, TimeUnit.MICROSECONDS); // пул не блокирущая операция . нужно сделать, что pollFinst немного подождал
         } catch (InterruptedException e) { //нужно сделать, что pollFinst немного подождал
             e.printStackTrace();
         }
         throw new RuntimeException("Oppps error"); // но метод по этой точки никогда не дойдет
             // или извлечет buyer, или извлечет и вернет null
     }
        }


