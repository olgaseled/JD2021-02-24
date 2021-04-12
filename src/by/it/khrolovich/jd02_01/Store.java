package by.it.khrolovich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static ListGoods priceList;


    public static void main(String[] args) {
        priceList = new ListGoods();
        List<Customer> customers = new ArrayList<>(120);//список покупателей
        System.out.println("Store opened");
        int numberCustomer = 0;
        for (int i = 0; i < Config.FINAL_TIME; i++) {

            int count = Util.getRandom(0, 2);
            for (int j = 0; j < count; j++) {
                numberCustomer++;
                Customer customer = new Customer(numberCustomer);
                customers.add(customer);
                customer.start();
            }
            Util.Sleep(1000);
        }
        for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                throw new RuntimeException();
            }
        }
        System.out.println("Store closed");
    }
}
