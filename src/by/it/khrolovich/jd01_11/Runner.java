package by.it.khrolovich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
       // List<String> list= new ArrayList<>();//правильнее, чтобы слева интерфейс. Хотя можно слева ArrayList
        List<String> list= new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        //list.remove("three");
        list.remove(2);
        System.out.println(list);
        System.out.println(list.get(1));

    }
}
