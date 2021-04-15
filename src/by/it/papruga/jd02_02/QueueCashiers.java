package by.it.papruga.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueCashiers {

    private static final Deque<Cashier> cashiers = new LinkedList<>();

    static synchronized void add(Cashier cashier){

        cashiers.addLast(cashier);

    }

    static synchronized Cashier pull(){

        return cashiers.pollFirst();
    }

    public static int getCashiersSize() {
        return cashiers.size();
    }
}
