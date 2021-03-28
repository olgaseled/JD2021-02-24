package by.it.korotkevich.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> words = new HashMap<>();
        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }
            String trimmedWord = word.trim().replaceAll("[^a-zA-Z']", "");
            if (!words.containsKey(trimmedWord)) {
                words.put(trimmedWord, 1);
            } else {
                words.put(trimmedWord, words.get(trimmedWord)+1);
            }
        }
        System.out.println(words);
    }
}
