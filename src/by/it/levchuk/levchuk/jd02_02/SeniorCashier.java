package by.it.levchuk.levchuk.jd02_02;
/*crash-noobik
Liauchuk Aliaksandr*/

public class SeniorCashier {
    static synchronized void newBuyer() {

    }

    private volatile static int buyerIn = 0;

    static boolean storeIsOpened() {

        return buyerIn != Сoefficients.TOTAL_BUYERS;

    }

    private volatile static int buyerOut = 0;

    static boolean storeIsClosed(){
        return buyerIn != Сoefficients.TOTAL_BUYERS;

    }
}
