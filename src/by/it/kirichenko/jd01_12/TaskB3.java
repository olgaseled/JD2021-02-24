package by.it.kirichenko.jd01_12;

import java.lang.reflect.Array;
import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        String[] peoples = {"Вася", "Петя", "Коля", "Иван"};
        ArrayList<String> peoplesArrayList = new ArrayList<>();
        LinkedList<String> peoplesLinkedList = new LinkedList<>();
        int countElements = 4096;
        peoplesArrayList.ensureCapacity(countElements);
        for (int i = 0, numberPeople = 0; i < countElements; i++, numberPeople++) {
            if (numberPeople==4){
                numberPeople=0;
            }
            peoplesArrayList.add(peoples[numberPeople]);
            peoplesLinkedList.add(peoples[numberPeople]);
        }
        long iniTime;
        Double delta;
        iniTime = System.nanoTime();
        System.out.println(process(peoplesArrayList));
        delta = (double) (System.nanoTime()-iniTime)/1000;
        System.out.println("Время выполнения с ArrayList: "+delta.toString()+" микросекунд.");

        iniTime = System.nanoTime();
        System.out.println(process(peoplesLinkedList));
        delta = (double) (System.nanoTime()-iniTime)/1000;
        System.out.println("Время выполнения с LinkedList: "+delta.toString()+" микросекунд.");
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
