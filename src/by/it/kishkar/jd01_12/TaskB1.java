package by.it.kishkar.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> result = new HashMap<>();

        while (true) {
            String words = scanner.next();
            if (words.equals("end")) {
                break;
            }
            String word = words.replaceAll("[.;:,!?]", "").trim();

            if (!result.containsKey(word)) {
                result.put(word, 1);
            } else {
                result.put(word, result.get(word) + 1);
            }
        }
        System.out.println(result);
    }
}
