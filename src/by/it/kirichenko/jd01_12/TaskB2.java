package by.it.kirichenko.jd01_12;

import java.lang.reflect.Array;
import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        String[] peoples = {"Вася", "Петя", "Коля", "Иван"};
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
