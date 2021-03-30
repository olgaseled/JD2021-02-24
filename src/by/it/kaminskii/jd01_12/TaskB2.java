package by.it.kaminskii.jd01_12;/* created by Kaminskii Ivan
 */

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        String[] peoples = new String[]{"1", "2", "3",};
        ArrayList<String> peoplesArrayL = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> peoplesLinkedL = new LinkedList<>(Arrays.asList(peoples));
        System.out.println(process(peoplesArrayL));
        System.out.println(process(peoplesLinkedL));

    }

    static String process(ArrayList<String> peoples) {
        Iterator<String > iterator = peoples.iterator();


        for (int i = 1; i <peoples.size(); i++) {
            if(!iterator.hasNext()) {
                iterator = peoples.iterator();
            }
            iterator.next();
                if (i == 2) {
                    iterator.remove();
                    i = 0;
                }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        Iterator<String > iterator = peoples.iterator();
        for (int i = 1; i <peoples.size(); i++) {

            if(iterator.hasNext()) {
                if (i == 2) {
                    iterator.remove();
                    i = 0;
                }
                iterator.next();
            }
            else if(!iterator.hasNext())iterator = peoples.iterator();

        }
        return peoples.get(0);
    }
}
