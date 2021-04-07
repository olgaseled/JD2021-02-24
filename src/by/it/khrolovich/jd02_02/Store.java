package by.it.khrolovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static PriceList priceList;


    public static void main(String[] args) {
        priceList = new PriceList();
        //List<Customer> customers = new ArrayList<>(120);//список покупателей
        List<Thread> customers = new ArrayList<>(120);//список покупателей

        for (int i=1;i<=2;i++){
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier, cashier.toString());
            thread.start();
        }

        System.out.println("Store opened");
        int numberCustomer = 0;
        while(Manager.storeIsOpened()) {
            for (int i = 0; i < Config.FINAL_TIME; i++) {

                int count = Util.getRandom(0, 2);
                for (int j = 0; j < count && Manager.storeIsOpened(); j++) {//если 99 и добавилось 2
                    // если нет проверки Manager.storeIsOpened() , то проскакивает больше покупателей//ЕЩВЩ
                    numberCustomer++;
                    Customer customer = new Customer(numberCustomer);
                    customers.add(customer);
                    customer.start();
                }
                Util.Sleep(1000);
            }
        }
        /*for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                throw new RuntimeException();
            }
        }*/

        for (Thread thread: customers) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                throw new RuntimeException();
            }
        }
        System.out.println("Store closed");
    }
}
