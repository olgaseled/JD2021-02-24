package by.it.korotkevich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {

    }

    String process(ArrayList<String> list) {
        boolean del = false;
        while (list.size() > 1) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (del) {
                    iterator.remove();
                }
                del = !del;
            }
        }
        return list.get(0);
    }

    String process(LinkedList<String> list) {
        while (list.size() > 1) {
            list.addLast(list.removeFirst());
            list.removeFirst();
        }
        return list.get(0);
    }
}
