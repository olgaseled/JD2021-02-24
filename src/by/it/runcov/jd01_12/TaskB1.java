package by.it.runcov.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> hashMap = new HashMap<>();
        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }
            String words = word.trim().replaceAll("[^a-zA-Z']","");
                if (!hashMap.containsKey(words)) {
                    hashMap.put(words,1);
                } else {
                    hashMap.put(words,hashMap.get(words)+1);
                }
        }
        System.out.println(hashMap);
    }
}
