package by.it.dudko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private static PriceList priceList;

    public static void main(String[] args) {
        String priceItems = "" +
                "яблоки : 2.0\n" +
                "крупа гречневая: 2.57\n" +
                "картофель: 1.85\n" +
                "морковь: 1.44\n" +
                "лук: 0.95\n" +
                "вермишель : 1.95\n" +
                "хлеб ржаной: 1.22\n" +
                "яйцо куриное : 2.75\n" +
                "масло сливочное: 4.1\n" +
                "масло подсолнечное: 4.1\n" +
                "молоко питьевое : 1.55\n" +
                "сахар-песок: 2.20\n" +
                "чай черный байховый: 1.7\n" +
                "мука пшеничная: 2.4\n" +
                "рис шлифованный: 2.0\n";

        System.out.println("Price is loaded");
        priceList = new PriceList(priceItems, StoreCurrency.BYN);
        List<Customer> customers = new ArrayList<>();
        System.out.println("Store is open");
        int customerId = 0;
        for (int second = 0; second < Config.MEASURE_TIME; second++) {
            int newCustomers = CustomerUtil.getRandom(2);
            for (int i = 0; i < newCustomers; i++) {
                Customer customer = new Customer(++customerId);
                customers.add(customer);
                customer.start();
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
