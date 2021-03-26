package by.it.voitsekhovskiy.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;

public class Runner {
    public static void main(String[] args) {
        SetC<String> hash = new SetC<>();
        hash.add("one");
        hash.add("two");
        hash.add("two2");

        SetC<String> hash2 = new SetC<>();
        hash2.add("one");
        hash2.add("two");
        System.out.println(hash.containsAll(hash2));
//
//        HashSet<String> hash3 = new HashSet<>();


//        List<String> list = new ArrayList<>();
//        list.add("one");
//        list.add(null);
//        System.out.println(hash.addAll(list));
//        System.out.println(hash);
    }
}
