package by.it.papruga.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Manager {

    private final AtomicInteger countCustomerIn = new AtomicInteger(0);
    private final AtomicInteger countQueueIn = new AtomicInteger(0);
    private final AtomicInteger countQueueOut = new AtomicInteger(0);
    private final AtomicInteger countCustomerOut = new AtomicInteger(0);

    void newCustomer() {
        countCustomerIn.getAndIncrement();
    }

    void completeCustomer(){ countCustomerOut.getAndIncrement(); }

    void queueIn(){
        countQueueIn.getAndIncrement();
    }

    void queueOut(){
        countQueueOut.getAndIncrement();
    }

    int getCountQueueIn() {
        return countQueueIn.get();
    }

    int getCountCustomerOut() {
        return countCustomerOut.get();
    }

    boolean storeIsOpened(){
        return countCustomerIn.get() != Config.PLAN;
    }
    boolean storeIsClosed(){
        return countCustomerOut.get() == Config.PLAN;
    }









}
