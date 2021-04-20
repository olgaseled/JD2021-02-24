package by.it.levchuk.levchuk.jd01_12;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

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
        double delta;
        iniTime = System.nanoTime();
        System.out.println(process(peoplesArrayList));
        delta = (double) (System.nanoTime()-iniTime)/1000;
        System.out.println("Time From ArrayList: "+ delta +" µs.");

        iniTime = System.nanoTime();
        System.out.println(process(peoplesLinkedList));
        delta = (double) (System.nanoTime()-iniTime)/1000;
        System.out.println("Time From LinkedList: "+ delta +" µs.");
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
