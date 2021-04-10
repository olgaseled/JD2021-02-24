package by.it.voitsekhovskiy.jd02_02;

public class Cashier implements Runnable {

    Integer num;

    private final static Object CASHIER_MONITOR = new Object();

    Cashier(Integer num) {
        this.num = num;
    }

    public static Object getCashierMonitor() {
        return CASHIER_MONITOR;
    }

    @Override
    public void run() {
        synchronized (CASHIER_MONITOR) {
            try {
                CASHIER_MONITOR.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("\tCashier #%d start work\n", num);
        while (!Manager.isClosedStore()) {
            Buyer firstBuyerInQueue = CheckoutQueue.getFirstBuyerInQueue();
            if (firstBuyerInQueue != null) {
                synchronized (firstBuyerInQueue.getMONITOR()) {
                    System.out.printf("\tCashier #%d started service the buyer #%d\n", num, firstBuyerInQueue.getNum());
                    Integer timeout = Util.getRandom(2000, 5000);
                    Util.sleep(timeout);
                    System.out.printf("\tCashier #%d finished service the buyer #%d\n", num, firstBuyerInQueue.getNum());
                    firstBuyerInQueue.setWaiting(false);
                    firstBuyerInQueue.notify();
                }
            } else {
                Util.sleep(1);
            }
        }
        System.out.printf("\tCashier #%d end work\n", num);
    }
}
