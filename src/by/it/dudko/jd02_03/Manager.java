package by.it.dudko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private static final AtomicInteger countCustomerIn = new AtomicInteger(0);
    private static final AtomicInteger countCustomerOut = new AtomicInteger(0);

    static synchronized void newCustomer() {
        countCustomerIn.getAndIncrement();
    }

    static void completeCustomer() {
        synchronized (Manager.class) {
            countCustomerOut.getAndIncrement();
        }
    }

    static boolean storeIsOpened() {
        return countCustomerIn.get() != Config.PLAN; //dev
    }

    static boolean storeIsClosed() {
        return countCustomerOut.get() == Config.PLAN; //dev
    }
}
