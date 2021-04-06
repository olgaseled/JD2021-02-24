package by.it.papruga.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {

    public static void main(String[] args) {

        String[] list = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        ArrayList<String> arList = new ArrayList<>(Arrays.asList(list));
        LinkedList<String> linList = new LinkedList<>(Arrays.asList(list));

        System.out.println(arList);
        System.out.println(linList);

        System.out.println(process(arList));
        System.out.println(process(linList));

    }

    static String process(ArrayList<String> peoples) {
        boolean del = false;

        while (peoples.size() > 1) {

            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (del) {
                    iterator.remove();
                    del = false;

                } else {
                    del = true;
                }
            }
        }
        return peoples.get(0);

    }

    static String process(LinkedList<String> peoples) {

        boolean del = false;
        while (peoples.size() > 1) {

            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (del) {
                    iterator.remove();
                    del = false;

                } else {
                    del = true;
                }
            }

        }
        return peoples.get(0);
    }
}

