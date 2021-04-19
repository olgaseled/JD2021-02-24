package by.it.dudko.jd02_02;

import java.util.Objects;

public class Manager {

    private volatile static int countCustomerIn = 0;
    private volatile static int countCustomerOut = 0;
    private volatile static boolean isEntranceAllowed = false;

    static synchronized void newCustomer() {
        countCustomerIn++;
    }

    static synchronized void completeCustomer() {
        countCustomerOut++;
    }

    static synchronized int getCustomersInStoreNumber() {
        return countCustomerIn - countCustomerOut;
    }

    public static void allowEntrance() {
        isEntranceAllowed = true;
    }

    public static void disallowEntrance() {
        isEntranceAllowed = false;
    }

    public static boolean storeIsClosed() {
        // return countCustomerOut == Config.PLAN;
        return !isEntranceAllowed && Objects.equals(countCustomerOut, countCustomerIn);
    }
}
