package by.it.korotkevich.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Store {


    static Map<String, Double> priceList = priceList();

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>(120);
        System.out.println("The store is opened.");
        int customerNumber = 0;
        for (int time = 0; time < Config.FINAL_TIME; time++) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count; i++) {
                Customer customer = new Customer(++customerNumber);
                customers.add(customer);
                customer.start();
            }
            Util.sleep(1000);
        }
        for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("The store is closed.");
    }

    static Map<String, Double> priceList() {
        Map<String, Double> priceList = new HashMap<>();
        priceList.put("Apple", 0.50);
        priceList.put("Banana", 0.90);
        priceList.put("Meat", 6.20);
        priceList.put("Juice", 2.0);
        priceList.put("Cake", 7.0);
        priceList.put("Fish", 5.60);
        return priceList;
    }

}
