package by.it.levchuk.levchuk.jd01_12;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        String[] peoples = {"АНГЕЛИНА", "Оля", "Петя", "Саша"};
        ArrayList<String> peoplesArrayList = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> peoplesLinkedList = new LinkedList<>(Arrays.asList(peoples));
        System.out.println(process(peoplesArrayList));
        System.out.println(process(peoplesLinkedList));
    }

    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();

        for (int currentPeople = 1; 1 < peoples.size(); currentPeople++) {
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
            }
            iterator.next();
            if (currentPeople == 2) {
                iterator.remove();
                currentPeople = 0;
            }
        }
        return peoples.get(0);
    }

    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();

        for (int currentPeople = 1; 1 < peoples.size(); currentPeople++) {
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
            }
            iterator.next();
            if (currentPeople == 2) {
                iterator.remove();
                currentPeople = 0;
            }
        }
        return peoples.get(0);
    }
}
