package by.it.zmushko.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ListB<String> listik = new ListB<>();
        SetC<String> listSet = new SetC<>();
        HashSet<String> set = new HashSet<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        set.add("null");
        set.add("null");
        set.add("1");
        set.add("1");
        set.addAll(list);
        System.out.println(set);
        System.out.println(set.size());

        listSet.add("null");
        listSet.add("null");
        listSet.add("1");
        listSet.add("1");
        listSet.addAll(list);
        System.out.println(listSet);
        System.out.println(listSet.size());
        System.out.println(listSet.contains("5"));
        System.out.println(listSet.remove("3"));
        System.out.println("after remove");
        System.out.println(listSet);
        System.out.println(listSet.size());
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        System.out.println(list.set(1, "123"));
//        System.out.println(list.addAll(list));
//        System.out.println(list);
//        listik.add("1");
//        listik.add("2");
//        listik.add("3");
//        listik.add("4");
//        System.out.println("Check my listik");
//        System.out.println(listik);
//        listik.add(2, "777");
//        listik.addAll(list);
//        System.out.println(listik);
//        System.out.println(listik.size());
//        System.out.println(listik.indexOf("777"));
//        System.out.println("Test my set");
//        listSet.add("1");
//        listSet.add("1");
//        listSet.add("2");
//        listSet.add("2");
//        System.out.println(listSet);
//        listSet.addAll(list);
//        System.out.println(listSet);
//        System.out.println("after remove");
//        System.out.println(listSet.remove("123"));
//        System.out.println(listSet);
//        listSet.addAll(list);
//        System.out.println(listSet);
//        System.out.println(listSet.contains("2"));

    }
}
