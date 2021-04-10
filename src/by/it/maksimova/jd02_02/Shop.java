package by.it.maksimova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public static void main(String[] args) {

        List<Buyer> buyers = new ArrayList<>(120);
        System.out.println("Shop opened");
        int time;
        int numberOfBuyers = 0;
        for (time = 0; time < Configuration.FINAL_TIME; time++) {
            int numberOfEnteredBuyers = Utils.getRandom(2);
            for (int i = 0; i < numberOfEnteredBuyers; i++) {
                Buyer buyer = new Buyer(++numberOfBuyers);
                buyers.add(buyer);
                buyer.start();
            }
            Utils.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");
    }

}
