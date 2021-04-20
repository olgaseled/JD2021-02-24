package by.it.khrolovich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class QueueCustomer {

    private BlockingDeque<Customer> customers;//blocking queue

    public QueueCustomer(int maxCapacity) {
        customers=  new LinkedBlockingDeque<>(maxCapacity);
    }

    void add(Customer customer) {
        try {
            customers.putLast(customer);//добавился в конец или заблокировался
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Customer poll() {
        try {
            return customers.pollFirst(100, TimeUnit.MICROSECONDS);//wait before poll from queue
            // неблолкирующая операция.
            // Или вернут null, или customer. И зависание. Получает покупателя или мгновенно, или с ожиданием
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //throw new RuntimeException("!");//До этой точки метод не дойдет, поток ниоткуда не прерывается
        //Неожиданное завершение потока
    }

}
