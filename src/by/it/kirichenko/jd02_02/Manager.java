package by.it.kirichenko.jd02_02;


class Manager {

    private volatile static int countCustomerIn = 0;
    private volatile static int countCustomerOut = 0;

    static synchronized void newBuyer() {
        countCustomerIn++;
    }

    static void completeBuyer() {
        synchronized (Manager.class) {
            countCustomerOut++;
        }
    }

    static boolean storeIsOpened() {
        //countCustomerIn<Config.PLAN; //prod
        return countCustomerIn != Config.PLAN; //dev
    }

    static boolean storeIsClosed() {
        // countCustomerOut>=Config.PLAN; //prod
        return countCustomerOut == Config.PLAN; //dev
    }
}
