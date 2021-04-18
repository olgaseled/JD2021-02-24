package by.it.korotkevich.jd02_02;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    //через менеджера можно контролировать количество клиенов в магазине
    //лучше использовать атомики из конкарента

    private final AtomicInteger countCustomerIn = new AtomicInteger(0);
    private final AtomicInteger countCustomerOut = new AtomicInteger(0);

    synchronized void newCustomer() {
        countCustomerIn.getAndIncrement();
    }

    void servedCustomer() {
        synchronized (Manager.class) {
            countCustomerOut.getAndIncrement();
        }
    }

    boolean storeIsOpened() {
        return countCustomerIn.get() != Config.PLAN;
    }

    boolean storeIsClosed() {
        return countCustomerOut.get() == Config.PLAN;
    }
}
