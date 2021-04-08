package by.it.seledtsova.jd02_02;



class Manager {

    private volatile static int countCustomerIn = 0;
    private volatile static int countCustomerOut = 0;

    static synchronized void newCustomer() {
        countCustomerIn++;
    }

    static void completeBuyer() {
        synchronized (Manager.class) {
            countCustomerOut++;
        }
    }

    static boolean storeIsOpened() {
        //countCustomerIn<Config.PLAN; //prod
        return countCustomerIn != Configuration.PLAN; //dev
    }

    static boolean storeIsClosed() {
        // countCustomerOut>=Config.PLAN; //prod
        return countCustomerOut == Configuration.PLAN; //dev
    }
}
