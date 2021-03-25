package by.it.zmushko.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ListB<String> listik = new ListB<>();
        Set<String> listSet = new HashSet<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.set(1, "123"));
        System.out.println(list.addAll(list));
        System.out.println(list);
        listik.add("1");
        listik.add("2");
        listik.add("3");
        listik.add("4");
        System.out.println("Check my listik");
        System.out.println(listik);
        listik.add(2, "777");
        listik.addAll(list);
        System.out.println(listik);
        System.out.println(listik.size());
        System.out.println(listik.indexOf("777"));

        listSet.add("1");
        listSet.add("1");
        listSet.add("1");
        listSet.add("1");
        System.out.println(listSet);

    }
}
