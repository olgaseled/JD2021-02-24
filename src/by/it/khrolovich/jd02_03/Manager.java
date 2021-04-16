package by.it.khrolovich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private static final AtomicInteger countCustomerIn = new AtomicInteger(0);
    private static final AtomicInteger countCustomerOut = new AtomicInteger(0);
    //убираем статик

    static void newCustomer() {
        countCustomerIn.getAndIncrement();
        //неатомарная операция
    }

    static void completeCustomer() {
        countCustomerOut.getAndIncrement();
    }

    static boolean storeIsOpened() {//люди могут заходить

        //return countCustomerIn<=Config.PLAN;//production
        return countCustomerIn.get() != Config.PLAN;//dev разработка
        //просто чтение, можно
    }

    static boolean storeIsClosed() {
        //return countCustomerOut>=Config.PLAN;
        return countCustomerOut.get() == Config.PLAN;
    }

}
