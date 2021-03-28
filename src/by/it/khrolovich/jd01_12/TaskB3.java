package by.it.khrolovich.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        String[] n = new String[4096];
        for (int i = 1; i <= n.length; i++) {
            n[i-1] = "n" + Integer.toString(i);
        }
        ArrayList<String> arrayPeoples = new ArrayList<>(Arrays.asList(n));
        LinkedList<String> linkedPeoples = new LinkedList<>(Arrays.asList(n));

        Long t = System.nanoTime();
        System.out.println(process(arrayPeoples));
        Long tA = System.nanoTime() - t;
        System.out.println("Время  работы ArrayList: " + tA/1000 + " мкс");

        t = System.nanoTime();
        System.out.println(process(linkedPeoples));
        Long tL = System.nanoTime() - t;
        System.out.println("Время  работы LinkedList: " + tL/1000 + " мкс");
        System.out.println("Время работы ArrayList значистельно больше вемени работы LinkedList: "+tA/1000+">"+tL/1000);
        System.out.println("В ArrayList при удалении происходит копирование в новый массив со смещением элементов");
        System.out.println("В LinkedList при удалении просто разрываются связи");
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
