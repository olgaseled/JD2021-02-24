package by.it.savchenko.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class TaskB2 {
    public static void main(String[] args) {
        System.out.println(process((ArrayList<String>)
                Arrays.asList("1, 2, 3")));
        System.out.println(process((LinkedList<String>)
                Arrays.asList("1, 2, 3")));
    }

    private static String process(ArrayList<String> peoples) {
        boolean del = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (del) {
                    iterator.remove();
                }
                del = !del;
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }
}


