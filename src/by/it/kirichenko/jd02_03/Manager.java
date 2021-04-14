package by.it.kirichenko.jd02_03;


import java.util.concurrent.atomic.AtomicInteger;

class Manager {

    private static final AtomicInteger COUNT_CUSTOMER_IN = new AtomicInteger(0);
    private static final AtomicInteger COUNT_CUSTOMER_OUT = new AtomicInteger(0);

    static synchronized void newBuyer() {

        COUNT_CUSTOMER_IN.getAndIncrement();
    }

    static void completeBuyer() {
        synchronized (Manager.class) {
            COUNT_CUSTOMER_OUT.getAndIncrement();
        }
    }

    static boolean storeIsOpened() {
        return COUNT_CUSTOMER_IN.get() != Config.PLAN; //dev
    }

    static boolean storeIsClosed() {
        // countCustomerOut>=Config.PLAN; //prod
        return COUNT_CUSTOMER_OUT.get() == Config.PLAN; //dev
    }
}
