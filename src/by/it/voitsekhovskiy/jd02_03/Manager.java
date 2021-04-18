package by.it.voitsekhovskiy.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private static final AtomicInteger countGoInBuyers = new AtomicInteger(0);
    private static final AtomicInteger countGoOutBuyers = new AtomicInteger(0);

    public static void addGoInBuyer() {
            countGoInBuyers.getAndIncrement();
    }

    public static void addGoOutBuyer() {
            countGoOutBuyers.getAndIncrement();
    }

    static boolean isOpenedStore() {
        return countGoInBuyers.get() != Config.PLAN;
    }

    static boolean isClosedStore() {
        return countGoOutBuyers.get() == Config.PLAN;
    }

//    public static Integer getCountGoInBuyers() {
//        return countGoInBuyers;
//    }
//
//    public static Integer getCountGoOutBuyers() {
//        return countGoOutBuyers;
//    }
}
