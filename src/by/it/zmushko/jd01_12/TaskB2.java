package by.it.zmushko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> arrayLists = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            arrayLists.add(String.valueOf(i));
        }
        for (int i = 0; i < 10; i++) {
            linkedList.add(String.valueOf(i));
        }
        System.out.println(arrayLists);
        System.out.println(process(arrayLists));
        System.out.println(process(linkedList));
        System.out.println(arrayLists);
    }

    static String process(ArrayList<String> peoples){
        Iterator<String> objectIterator = peoples.iterator();

       // while (peoples.size() != 1) {
            peoples.trimToSize();
            int check = 0;
            while (objectIterator.hasNext()) {
//                check++;
//                if (check % 2 != 0);
//                peoples.remove(objectIterator);
                System.out.println(peoples);
            }
       // }
        return peoples.toString();
    }

    static String process(LinkedList<String> peoples){
        return null;
    }
}
