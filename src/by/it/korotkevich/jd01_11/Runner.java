package by.it.korotkevich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListB<>();
        List<String> list2 = new ListB<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list2.add("five");
        list2.add("six");
        list2.add("seven");
        list2.add("eight");
        System.out.println(list);
        list.addAll(list2);
        System.out.println(list);
    }
}
