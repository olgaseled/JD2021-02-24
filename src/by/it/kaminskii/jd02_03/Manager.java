package by.it.kaminskii.jd02_03;/* created by Kaminskii Ivan
 */

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private static AtomicInteger COUNT_BUYER_IN = new AtomicInteger(0);
    private static AtomicInteger COUNT_BUYER_OUT = new AtomicInteger(0);

    static void newBuyer() {
            COUNT_BUYER_IN.getAndIncrement();
    }

    static boolean marketIsOpened(){
        return COUNT_BUYER_IN.get()!= Config.PLAN_BUYER;
    }
    static boolean marketIsClosed(){
        return COUNT_BUYER_OUT.get() == Config.PLAN_BUYER;
    }
}
