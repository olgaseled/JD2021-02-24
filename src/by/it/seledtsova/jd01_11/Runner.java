package by.it.seledtsova.jd01_11;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
    List<String> myListA=new ListA<>();
    List<String> myListB=new ListB<>();
    List<String> list=new ArrayList<>();

    list.add("one"); myListB.add ("one");
    list.add("two");  myListB.add("two");
    list.add("three"); myListB.add("three");
    list.add("four"); myListB.add("four");

    System.out.println("ArrayList"+list+"\nmyListA"+myListA);
        System.out.println();

    list.remove("start"); myListB.remove("start");
    list.remove(3); myListB.remove(3);

    System.out.println("ArrayList"+list+"\nmyListB"+myListB);
        System.out.println();

    System.out.println("ArrayList(0):"+list.get(0)+"\nmyListB(0):"+myListB.get(0));
        System.out.println();

    list.set(2, "five"); myListB.set(2, "five");
    System.out.println("ArrayList (2):"+list.set(2, "five")+"\nmyListB(2):"+myListB.set(2, "five"));

        System.out.println(list+" "+myListB);
    }
}
