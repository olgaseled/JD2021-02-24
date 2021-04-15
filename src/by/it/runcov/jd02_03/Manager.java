package by.it.runcov.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Manager {

    private final AtomicInteger countBuyerIn = new AtomicInteger(0);
    private final AtomicInteger countBuyerOut =  new AtomicInteger(0);

     synchronized void newBuyer() {
        countBuyerIn.getAndIncrement();
    }

     void completeBuyer() {
        synchronized (Manager.class) {
            countBuyerOut.getAndIncrement();
        }
    }

     boolean shopIsOpened() {
        return countBuyerIn.get() != Constant.PLAN;
    }

     boolean shopIsClosed() {
        return countBuyerOut.get() == Constant.PLAN;
    }
}
