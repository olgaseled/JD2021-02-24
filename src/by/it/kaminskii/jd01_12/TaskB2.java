package by.it.kaminskii.jd01_12;/* created by Kaminskii Ivan
 */

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        String[] peoples = new String[]{"1", "2", "3",};
        ArrayList<String> peoplesArrayL = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> peoplesLinkedL = new LinkedList<>(Arrays.asList(peoples));
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
