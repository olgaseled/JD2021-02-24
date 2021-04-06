package by.it.kaminskii.jd01_12;/* created by Kaminskii Ivan
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        String[] peoples = new String[]{"1", "2", "3","4","1","23","12"};
        ArrayList<String> peoplesArrayL = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> peoplesLinkedL = new LinkedList<>(Arrays.asList(peoples));
        System.out.println(process(peoplesArrayL));
        System.out.println(process(peoplesLinkedL));

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
}

