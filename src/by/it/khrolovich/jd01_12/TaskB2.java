package by.it.khrolovich.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> arrayPeoples = new ArrayList<>(Arrays.asList("Марина", "Света", "Артем"));
        LinkedList<String> linkedPeoples = new LinkedList<>(Arrays.asList("Марина", "Света", "Артем"));
        System.out.println(process(arrayPeoples));
        System.out.println(process(linkedPeoples));
    }

    static String process(ArrayList<String> peoples) {

        boolean isDel = false;
        while (peoples.size() != 1) {
            Iterator<String> itrArray = peoples.iterator();

            while (itrArray.hasNext()) {
                String next = itrArray.next();
                if (isDel) {
                    itrArray.remove();
                    isDel = false;
                } else {
                    isDel = true;
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        boolean isDel = false;
        while (peoples.size() != 1) {
            Iterator<String> itrLinked = peoples.iterator();

            while (itrLinked.hasNext()) {
                String next = itrLinked.next();
                if (isDel) {
                    itrLinked.remove();
                    isDel = false;
                } else {
                    isDel = true;
                }
            }
        }

       return peoples.getFirst();
    }
}
