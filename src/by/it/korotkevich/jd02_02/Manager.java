package by.it.korotkevich.jd02_02;

public class Manager {
    //через менеджера можно контролировать количество клиенов в магазине
    //лучше использовать атомики из конкарента

    private volatile static int countCustomerIn = 0;
    private volatile static int countCustomerOut = 0;

    static synchronized void newCustomer() {
        countCustomerIn++;
    }

    static void servedCustomer() {
        synchronized (Manager.class) {
            countCustomerOut++;
        }
    }

    static boolean storeIsOpened() {
        return countCustomerIn != Config.PLAN;
    }

    static boolean storeIsClosed() {
        return countCustomerOut == Config.PLAN;
    }
}
