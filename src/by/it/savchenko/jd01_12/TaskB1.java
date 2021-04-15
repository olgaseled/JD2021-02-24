package by.it.savchenko.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            String word = scanner.next();

            word = word.replaceAll("[.,;:]"," ");
            if (word.equals("end")) {
                break;
            }

            for (String s : word.split(" ")) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                }
                else {
                    map.put(s, 1);
                }
            }
            map.remove("");
        }
        System.out.println(map);
    }
}