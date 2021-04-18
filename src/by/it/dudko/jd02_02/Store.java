package by.it.dudko.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private static PriceList priceList;

    public static void main(String[] args) {

        priceList = new PriceList(Config.PRICE_ITEMS, StoreCurrency.BYN);
        System.out.println(Config.SIGN_INFO + "\tPrice is loaded");

        Manager.allowEntrance(); // unlock doors

        List<Thread> threads = new ArrayList<>(120);

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            threads.add(cashier);
            cashier.start();
        }
        System.out.println(Config.SIGN_INFO + "\tStore is open");
        int customerId = 0;
        int nth = Config.NTH_PENSIONER; // short alias
        int newCustomers;


        for (int second = 0; second < Config.MEASURE_TIME; second++) {
            if (second % 30 == 0) {
                System.out.printf(
                        "%s\t%02d:%02d customers in store: %d\n",
                        Config.SIGN_CHECKPOINT,
                        second / 60,
                        second % 60,
                        Manager.getCustomersInStoreNumber());
            }
            int sec = second % 60;
            int needCount = 10 + (sec < 30 ? sec : 60 - sec);
            int customersInStore = Manager.getCustomersInStoreNumber();
            if (needCount > customersInStore) {
                int delta = needCount - customersInStore;
                newCustomers = StoreUtil.getRandom(delta - 1, delta);
                for (int i = 0; i < newCustomers; i++) {
                    Customer customer = StoreUtil.getRandom(1, nth) < nth
                            ? new Customer(++customerId)
                            : new Pensioner(++customerId);
                    threads.add(customer);
                    customer.start();
                }
            }
            StoreUtil.sleep(1000);

        }

        Manager.disallowEntrance(); // lock entrance doors

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Config.SIGN_INFO + "\tStore is closed");
    }

    public static PriceList getPriceList() {
        return priceList;
    }
}
