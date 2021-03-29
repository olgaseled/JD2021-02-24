package by.it.khrolovich.jd01_12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        Random random = new Random();
        int count = 1;
        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }

            int key = random.nextInt(1000) + 1;
            // hashMap.put(,word);

              /*  if (hashMap.containsKey(word)) {
                    hashMap.put(word, hashMap.get(word) + 1);
                } else {
                    hashMap.put(word, count);
                }*/
        }
    }
}
