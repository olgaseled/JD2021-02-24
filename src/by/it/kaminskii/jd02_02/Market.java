package by.it.kaminskii.jd02_02;/* created by Kaminskii Ivan
 */

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        List<Thread> buyerList = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier, cashier.toString());
            buyerList.add(thread);

            System.out.println("Market opened");
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
            for (Thread buyer : buyerList) {
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Market closed");
        }
    }
}