package by.it.kirichenko.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Store {

    public static void main(String[] args) {

        putProductsInWindow();

        List<Buyer> buyers = new ArrayList<>(120);
        System.out.println("Store opened.");
        int numberBuyer = 0;
        for (int time = 0; time < Config.FINAL_TIME; time++) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyers.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Store closed.");
    }

    private static void putProductsInWindow() {
        StoreWindow.addProduct("ball", 50.00);
        StoreWindow.addProduct("kick scooter", 500.00);
        StoreWindow.addProduct("boxing gloves", 500.00);
        StoreWindow.addProduct("bike", 2000.00);
        StoreWindow.addProduct("tennis ball", 5.00);
    }
}
