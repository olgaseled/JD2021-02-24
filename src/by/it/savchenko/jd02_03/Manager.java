package by.it.savchenko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Manager {

    private final AtomicInteger countCustomerIn = new AtomicInteger(0);
    private final AtomicInteger countCustomerOut = new AtomicInteger(0);

    synchronized void newCustomer() {
        countCustomerIn.getAndIncrement();
    }

    void completeCustomer() {
        synchronized (Manager.class) {
            countCustomerOut.getAndIncrement();
        }
    }

    boolean storeIsOpened() {
        //countCustomerIn<Config.PLAN; //prod
        return countCustomerIn.get() != Config.PLAN; //dev
    }

    boolean storeIsClosed() {
        // countCustomerOut>=Config.PLAN; //prod
        return countCustomerOut.get() == Config.PLAN; //dev
    }
}
