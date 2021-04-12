package by.it.dudko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private static PriceList priceList;

    static int customersInStore = 0;

    public static void main(String[] args) {

        priceList = new PriceList(Config.PRICE_ITEMS, StoreCurrency.BYN);
        System.out.println("Price is loaded");

        List<Customer> customers = new ArrayList<>();
        System.out.println("Store is open");

        int customerId = 0;
        int nth = Config.NTH_PENSIONER; // short alias
        int newCustomers;
        for (int second = 0; second < Config.MEASURE_TIME; second++) {
            // int newCustomers = CustomerUtil.getRandom(Config.MAX_CAPACITY_PER_SECOND);
            int sec = second % 60;
            int needCount = 10 + (sec < 30 ? sec : 60 - sec);
            if (needCount > customersInStore) {
                int delta = needCount - customersInStore;
                newCustomers = CustomerUtil.getRandom(delta - 1, delta + 1);
                // System.out.printf("t=%-3d sec=%-2d n=%-2d in=%-2d\n", second, sec, needCount, customersInStore);
                for (int i = 0; i < newCustomers; i++) {
                    Customer customer = CustomerUtil.getRandom(1, nth) < nth
                            ? new Customer(++customerId)
                            : new Pensioner(++customerId);
                    customers.add(customer);
                    customer.start();
                }
            }
            CustomerUtil.sleep(1000);
        }

        for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Store is closed");
    }

    public static PriceList getPriceList() {
        return priceList;
    }
}
