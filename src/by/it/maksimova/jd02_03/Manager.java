package by.it.maksimova.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final AtomicInteger numberOfBuyersInShop = new AtomicInteger(0);
    private final AtomicInteger numberOfBuyersOutShop = new AtomicInteger(0);

    void newBuyer() {
        numberOfBuyersInShop.getAndIncrement();
    }

    void completeBuyer() {
        numberOfBuyersOutShop.getAndIncrement();
    }

    boolean shopIsOpened() {
        return numberOfBuyersInShop.get() != Configuration.PLAN;
    }

    boolean shopIsClosed() {
        return numberOfBuyersOutShop.get() == Configuration.PLAN;
    }

}
