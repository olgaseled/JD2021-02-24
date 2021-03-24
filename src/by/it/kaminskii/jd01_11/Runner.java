package by.it.kaminskii.jd01_11;

import by.it._classwork_.jd01_11.ListA;


import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListB<>();
        List<String> listerList= new ListB<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(2);
        list.get(2);
        list.set(2,"triiiii");
        list.add(3,"beng");
        list.set(0,"3");
        System.out.println(list +"\n");
    }
}
