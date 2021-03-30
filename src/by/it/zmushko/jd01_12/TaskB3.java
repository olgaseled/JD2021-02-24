package by.it.zmushko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        Timer clock = new Timer();
        ArrayList<String> arrayLists = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            arrayLists.add(String.valueOf(i));
        }
        for (int i = 0; i < 10; i++) {
            linkedList.add(String.valueOf(i));
        }
        System.out.println(process(arrayLists) + clock);
        System.out.println(process(linkedList) + clock);
    }

    static String process(ArrayList<String> peoples) {

        int counter = 0;
        while (peoples.size() != 1) {
            Iterator<String> objectIterator = peoples.iterator();
            while (objectIterator.hasNext()) {
                counter++;
                objectIterator.next();
                if (counter % 2 != 1) {
                    objectIterator.remove();
                }
            }
        }

        return peoples.toString().replaceAll("[\\[\\]]", "");
    }

    static String process(LinkedList<String> peoples) {
        int counter = 0;
        while (peoples.size() != 1) {
            Iterator<String> objectIterator = peoples.iterator();
            while (objectIterator.hasNext()) {
                counter++;
                objectIterator.next();
                if (counter % 2 != 1) {
                    objectIterator.remove();
                }
            }
        }
        return peoples.toString().replaceAll("[\\[\\]]", "");
    }

    public static class Timer {
        private long iniTime;
        private Double Delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        ;

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();
            return " Прошло " + Delta.toString() + " микросек.";
        }
    }

}
