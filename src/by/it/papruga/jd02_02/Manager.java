package by.it.papruga.jd02_02;

class Manager {

    private volatile static int countCustomerIn = 0;
    private volatile static int countCustomerOut = 0;

    static synchronized void newCustomer() {
        countCustomerIn++;
    }

    static void completeCustomer(){
        synchronized (Manager.class){
            countCustomerOut++;
        }
    }

    static boolean storeIsOpened(){
        return countCustomerIn != Config.PLAN;
    }
    static boolean storeIsClosed(){
        return countCustomerOut == Config.PLAN;
    }









}
