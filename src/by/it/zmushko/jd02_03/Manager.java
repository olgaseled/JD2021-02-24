package by.it.zmushko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Manager {

    private final AtomicInteger countPeopleInShop = new AtomicInteger(0);
    private final AtomicInteger countPeopleOutShop = new AtomicInteger(0);

    void peopleCome() {
        countPeopleInShop.getAndIncrement();
    }

    void counterPeople(){
        countPeopleOutShop.getAndIncrement();
    }

    boolean storeOpen() {
        return countPeopleInShop.get() != Constants.MAX_LIMIT_PEOPLE_IN_STORE;
    }

    boolean storeClose() {
        return countPeopleOutShop.get() == Constants.MAX_LIMIT_PEOPLE_IN_STORE;
    }


}
