package by.it.khrolovich.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> arrayPeoples = new ArrayList<>(Arrays.asList("Марина", "Света", "Артем"));
        LinkedList<String> linkedPeoples = new LinkedList<>(Arrays.asList("Марина", "Света", "Артем"));
        System.out.println(process(arrayPeoples));
        System.out.println(process(linkedPeoples));
    }
    static String process(ArrayList<String> peoples){
        return "";
    }

    static String process(LinkedList<String> peoples){
        return "";
    }
}
