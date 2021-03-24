package by.it.levchuk.levchuk.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList=new ListA<>();
        List<String> arList=new ArrayList<>();

        myList.add("one"); arList.add("one");
        myList.add("two"); arList.add("two");
        myList.add("three"); arList.add("three");
        myList.add("four"); arList.add("four");

        System.out.println("myist:"+myList+"\narList:"+arList);

        myList.add(2,"three"); arList.add(2,"three");
        myList.add(0,"start"); arList.add(0,"start");

        System.out.println("myList:"+myList+"\narList:"+arList);

        myList.remove("start"); arList.remove("start");
        myList.remove(3); arList.remove(3);

        System.out.println("myList:"+myList+"\narList:"+arList);
        System.out.println("myList(0):"+myList.get(0)+"\narList(0)"+arList.get(0));
    }
}
