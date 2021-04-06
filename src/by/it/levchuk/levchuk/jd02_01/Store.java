package by.it.levchuk.levchuk.jd02_01;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayDeque;
import java.util.Queue;

import static by.it.levchuk.levchuk.jd02_01.ConstAndCoeffic.VISIT_TIME;

public class Store {
    public static void main(String[] args) {
        System.out.println("МАГАЗИН ОТКРЫЛСЯ");
        int numberBuyer = 0;
        Queue<Buyer> queue = new ArrayDeque<>();
        //ArrayList<Buyer> buyers =new ArrayList<>(VISIT_TIME);
        for (int time = 0; time < VISIT_TIME; time++) {
            int count = Tools.getRandom();
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                queue.add(buyer);
                //buyers.add(buyer);
                buyer.start();
            }
            Tools.sleep(1000);
        }
        for (Buyer buyer : queue) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("МАГАЗИН ЗАКРЫЛСЯ");
    }
}
