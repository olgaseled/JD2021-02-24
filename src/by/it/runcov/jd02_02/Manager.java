package by.it.runcov.jd02_02;

class Manager {

    private volatile static int countBuyerIn = 0;
    private volatile static int countBuyerOut = 0;

    static synchronized void newBuyer() {
        countBuyerIn++;
    }

    static void completeBuyer() {
        synchronized (Manager.class) {
            countBuyerOut++;
        }
    }

    static boolean shopIsOpened() {
        return countBuyerIn != Constant.PLAN;
    }

    static boolean shopIsClosed() {
        return countBuyerOut == Constant.PLAN;
    }
}
