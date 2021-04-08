package by.it.kaminskii.jd02_02;/* created by Kaminskii Ivan
 */

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Buyer> buyerList = new ArrayList<>();
        int numberBuyer = 0;
        for (int time = 0; time < Config.FINAL_TIME; time++) {
            int buyers = Helper.randomValue(2);
            for (int j = 0; j < buyers; j++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyerList.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
//            Good.fillPrice();
//            Basket.filStringJoiner();
        }
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }
}
