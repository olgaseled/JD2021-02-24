package by.it.kishkar.jd02_02;


public class Manager {
    private volatile static int countCustomerIn = 0;
    private volatile static int countCustomerOut = 0;

    static synchronized void newCustomer() {
        countCustomerIn++;
    }

    static void completeCustomer() {
        synchronized (Manager.class) {
            countCustomerOut++;
        }
    }

    static boolean storeIsOpened() {
        //countCustomerIn<Dispatcher.PLAN; //prod
        return countCustomerIn != Dispatcher.PLAN; //dev
    }

    static boolean storeIsClosed() {
        // countCustomerOut>=Dispatcher.PLAN; //prod
        return countCustomerOut == Dispatcher.PLAN; //dev
    }
}
