package by.it.dudko.jd02_02;

import java.util.List;

public class Cashier extends Thread implements ICashier {

    private double checkSum = 0;

    public Cashier(int number) {
        super("Cashier #" + number);
    }

    @Override
    public void run() {
        System.out.println(Config.SIGN_INFO + this + " opened");
        while (!Manager.storeIsClosed()) {
            Customer customer = QueueCustomers.poll();
            if (customer != null) {
                checkSum = 0;
                synchronized (customer.getMONITOR()) {
                    System.out.println(this + " started service " + customer);
                    List<Good> customerGoods = customer.takeOutAllGoods();
                    for (Good good : customerGoods) {
                        scanGood(good);
                    }
                    sayCheckSum(customer);
                    int actionTime = StoreUtil.getRandom(
                            Config.CASHIER_SERVICE_MIN_TIME,
                            Config.CASHIER_SERVICE_MAX_TIME
                    );
                    StoreUtil.sleep(actionTime);
                    System.out.println(this + " finished service " + customer);
                    customer.setWaiting(false);
                    customer.getMONITOR().notify();
                }
            } else {
                // cashier is waiting
                StoreUtil.sleep(1);
            }
        }

        System.out.println(Config.SIGN_INFO + this + " closed");
    }


    @Override
    public void scanGood(Good good) {
        System.out.printf("\t%s %s scanned %s\n", Config.SIGN_CASHIER_SCAN, this, good);
        countGood(good.getPrice());
    }

    public void countGood(double cost) {
        checkSum += cost;
    }

    @Override
    public void takeBreak() {

    }

    @Override
    public void sayCheckSum(Customer customer) {
        System.out.printf("\t%s %s counted total check %.2f for %s\n",
                Config.SIGN_CASHIER_TOTAL,
                this,
                checkSum,
                customer);
    }

    @Override
    public String toString() {
        return "\t" + this.getName();
    }
}
