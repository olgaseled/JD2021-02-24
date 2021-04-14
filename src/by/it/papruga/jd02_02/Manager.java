package by.it.papruga.jd02_02;

class Manager {

    private volatile static int countCustomerIn = 0;
    private volatile static int countQueueIn = 0;
    private volatile static int countQueueOut = 0;
    private volatile static int countCustomerOut = 0;

    static synchronized void newCustomer() {
        countCustomerIn++;
    }

    static void completeCustomer(){
        synchronized (Manager.class){
            countCustomerOut++;
        }
    }

    static synchronized void queueIn(){
        countQueueIn++;
    }

    static synchronized void queueOut(){
        countQueueOut++;
    }

    public static int getCountQueueIn() {
        return countQueueIn;
    }

    public static int getCountCustomerOut() {
        return countCustomerOut;
    }

    static boolean storeIsOpened(){
        return countCustomerIn != Config.PLAN;
    }
    static boolean storeIsClosed(){
        return countCustomerOut == Config.PLAN;
    }









}
