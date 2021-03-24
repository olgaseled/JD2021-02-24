package by.it.kirichenko.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        list.remove(2);
        list.set(2, "three");
        list.add(0,"zero");
        System.out.println(list);
        System.out.println(list.get(1));

    }
}
