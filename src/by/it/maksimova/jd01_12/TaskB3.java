package by.it.maksimova.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        String [] array = new String [4096];
        ArrayList<String> arrayListOfPeople = new ArrayList<>(Arrays.asList(array));
        LinkedList<String> linkedListOfPeople = new LinkedList<>(Arrays.asList(array));
        long startTimeForArrayList = System.currentTimeMillis();
        System.out.println(process(arrayListOfPeople));
        long endTimeForArrayList = System.currentTimeMillis();
        System.out.println("Time for ArrayList -  "+(endTimeForArrayList-startTimeForArrayList)+" seconds");
        long startTimeForLinkedList = System.currentTimeMillis();
        System.out.println(process(linkedListOfPeople));
        long endTimeForLinkedList = System.currentTimeMillis();
        System.out.println("Time for LinkedList - "+(endTimeForLinkedList-startTimeForLinkedList)+" seconds");
    }

    static String process(ArrayList<String> peoples) {

        boolean a = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (a) {
                    iterator.remove();
                }
                a = !a;
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        while (peoples.size()>1){
            String s = peoples.removeFirst();
            peoples.addLast(s);
            peoples.removeFirst();
        }
        return peoples.get(0);
    }
}
