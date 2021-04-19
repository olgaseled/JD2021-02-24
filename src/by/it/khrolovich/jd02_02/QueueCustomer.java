package by.it.khrolovich.jd02_02;

import java.util.*;

public class QueueCustomer {

    private static final Object MONITOR_QUEUE = new Object();
    private static Comparator<Customer> newComparator = new Comparator<>(){
        @Override
        public int compare(Customer o1, Customer o2) {
            return ((o2.pensioneer)?1:0) - ((o1.pensioneer)?1:0);
        }
    };
    //private static Deque<Customer> customers = new LinkedList<>();//очередь не потокобезопасна!
    private static Queue<Customer> customers = new PriorityQueue<>(newComparator);
    static void add(Customer customer) {
        synchronized (MONITOR_QUEUE) {
                customers.add(customer);
        }
    }

    static Customer poll() {
        synchronized (MONITOR_QUEUE) {
            return customers.poll();
        }
    }

}
