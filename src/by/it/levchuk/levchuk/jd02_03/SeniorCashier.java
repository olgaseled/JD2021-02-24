package by.it.levchuk.levchuk.jd02_03;
/*crash-noobik
Liauchuk Aliaksandr*/

class SeniorCashier {

    private volatile static int buyerIn = 0;
    private volatile static int buyerOut = 0;

    static synchronized void newBuyer() {buyerIn++;}

    static void lastBuyer() {synchronized (SeniorCashier.class) {buyerOut++;}}

    static boolean storeIsOpened() {return buyerIn != Сoefficients.TOTAL_BUYERS;}

    static boolean storeIsClosed() {return buyerOut == Сoefficients.TOTAL_BUYERS;}
}
