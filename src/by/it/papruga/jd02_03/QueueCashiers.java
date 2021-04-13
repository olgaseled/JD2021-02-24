package by.it.papruga.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueCashiers {

    private final BlockingDeque<Cashier> cashiers
            = new LinkedBlockingDeque<>(Config.CASHIERS_RESERVE);

    void add(Cashier cashier){

        try {
            cashiers.putLast(cashier);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Cashier pull(){ return cashiers.pollFirst(); }

    public int getCashiersSize() {
        return cashiers.size();
    }
}
