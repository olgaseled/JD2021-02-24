package by.it.maksimova.jd02_03;

public class Manager {

    private volatile static int numberOfCustomersInShop = 0;
    private volatile static int numberOfCustomersOutShop = 0;

    static synchronized void newCustomer() {
        numberOfCustomersInShop++;
    }

    static void completeCustomer() {
        synchronized (Manager.class) {
            numberOfCustomersOutShop++;
        }
    }

    static boolean shopIsOpened() {
        return  numberOfCustomersInShop!= Configuration.PLAN;
    }

    static boolean shopIsClosed() {
        return numberOfCustomersOutShop == Configuration.PLAN;
    }

}
