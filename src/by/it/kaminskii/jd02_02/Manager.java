package by.it.kaminskii.jd02_02;/* created by Kaminskii Ivan
 */

public class Manager {
    private static int buyerIn = 0;
    private static int buyerOut = 0;

    static void newBuyer() {
            buyerIn++;
    }

    static boolean marketIsOpened(){
        return buyerIn != Config.PLAN_BUYER;
    }
    static boolean marketIsClosed(){
        return buyerOut == Config.PLAN_BUYER;
    }
}
