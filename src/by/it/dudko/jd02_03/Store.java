package by.it.dudko.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Store {

    private static PriceList priceList;

    public static void main(String[] args) {

        priceList = new PriceList(Config.PRICE_ITEMS, StoreCurrency.BYN);
        System.out.println(Config.SIGN_INFO + "\tPrice is loaded");

        ExecutorService executorServiceCashiers = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            executorServiceCashiers.execute(cashier);
        }
        executorServiceCashiers.shutdown();
        System.out.println(Config.SIGN_INFO + "\tStore is open");
        int customerId = 0;
        int nth = Config.NTH_PENSIONER; // short alias

        while (Manager.storeIsOpened()) {
            int count = StoreUtil.getRandom(2);
            for (int i = 0; i < count && Manager.storeIsOpened(); i++) {
                Customer customer = by.it.dudko.jd02_03.StoreUtil.getRandom(1, nth) < nth
                        ? new Customer(++customerId)
                        : new Pensioner(++customerId);
                customer.start();
            }
            StoreUtil.sleep(1000);
        }
        try {
            while (!executorServiceCashiers.awaitTermination(1, TimeUnit.HOURS)) {
                System.out.println("wow");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Config.SIGN_INFO + "\tStore is closed");
    }

    public static PriceList getPriceList() {
        return priceList;
    }
}
