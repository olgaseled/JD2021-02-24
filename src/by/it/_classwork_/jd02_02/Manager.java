package by.it._classwork_.jd02_02;

class Manager {

    private volatile static int COUNT_BUYER_IN = 0;
    private volatile static int COUNT_BUYER_OUT = 0;

    static synchronized void newCustomer() {
        COUNT_BUYER_IN++;
    }

    static void completeCustomer() {
        synchronized (Manager.class) {
            COUNT_BUYER_OUT++;
        }
    }

    static boolean storeIsOpened() {
        //countCustomerIn<Config.PLAN; //prod
        return COUNT_BUYER_IN != Config.PLAN; //dev
    }

    static boolean storeIsClosed() {
        // countCustomerOut>=Config.PLAN; //prod
        return COUNT_BUYER_OUT == Config.PLAN; //dev
    }
}
