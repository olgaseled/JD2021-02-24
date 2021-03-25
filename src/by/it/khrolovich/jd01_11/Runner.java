package by.it.khrolovich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();//правильнее, чтобы слева интерфейс. Хотя можно слева ArrayList
        List<String> myList = new ListB<>();
        //add
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        //toString
        System.out.println(list);
        System.out.println(myList);
        //remove
        list.remove(2);
        myList.remove(2);
        System.out.println(list);
        System.out.println(myList);
        //get
        System.out.println(list.get(1));
        System.out.println(myList.get(1));
        list.set(2, "set");
        myList.set(2, "set");
        System.out.println(list);
        System.out.println(myList);
        list.add(1, "newset");
        myList.add(1, "newset");
        System.out.println(list);
        System.out.println(myList);
        System.out.println("addAll");
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list.addAll(list2);
        myList.addAll(list2);
        System.out.println(list);
        System.out.println(myList);
    }
}
