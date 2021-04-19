package by.it.khrolovich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final AtomicInteger countCustomerIn = new AtomicInteger(0);
    private final AtomicInteger countCustomerOut = new AtomicInteger(0);
    //убираем статик

    void newCustomer() {
        countCustomerIn.getAndIncrement();
        //неатомарная операция
    }

    void completeCustomer() {
        countCustomerOut.getAndIncrement();
    }

    boolean storeIsOpened() {//люди могут заходить
        //return countCustomerIn<=Config.PLAN;//production
        return countCustomerIn.get() != Config.PLAN;//dev разработка
        //просто чтение, можно
    }

    boolean storeIsClosed() {
        //return countCustomerOut>=Config.PLAN;
        return countCustomerOut.get() == Config.PLAN;
    }

}
