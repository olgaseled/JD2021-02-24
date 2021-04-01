package by.it.maksimova.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        System.out.println(process((ArrayList<String>) Arrays.asList("A, B, C")));
        System.out.println(process((LinkedList<String>) Arrays.asList("A, B, C")));
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
