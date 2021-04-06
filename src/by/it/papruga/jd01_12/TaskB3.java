package by.it.papruga.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {

    public static void main(String[] args) {

        String element = "people ";

        ArrayList<String> arList = new ArrayList<>();
        LinkedList<String> linList = new LinkedList<>();
     //   LinkedList<String> linList2 = new LinkedList<>();

        for (int i = 0; i < 4096; i++) {

            arList.add(element + i);
            linList.add(element + i);
        //    linList2.add(element + i);

        }

        System.out.println(process(arList));
        System.out.println(process(linList));
     //   System.out.println(process2(linList2));

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
/*
    static String process2(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            peoples.addFirst(peoples.removeLast());
            peoples.removeLast();
        }
        return peoples.get(0);

    }



public static  class Timer {
        private long iniTime;

        public Timer() { iniTime= System.nanoTime(); }
        public String toString(){
            double delta = (double)(System.nanoTime()-iniTime)/1000;
            iniTime = System.nanoTime();
            return " - Прошло "+ delta +" микросекунд.";
        }

}
 */

}
