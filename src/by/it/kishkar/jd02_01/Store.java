package by.it.kishkar.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static void main(String[] args) {
        System.out.println("start");
        List<Buyer> buyers = new ArrayList<>();
        int n = 0;
        for (int sec = 1; sec <= 120; sec++) {
            int count = Helper.getRandom(2);
            for (int i = 1; i <= count; i++) {

                Buyer buyer = new Buyer(++n);
                buyers.add(buyer);
                buyer.start();

            }
            try {
                for (Buyer buyer : buyers) {
                    buyer.join();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }   System.out.println("close");

    }
}
