package by.it.khrolovich.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
        int count = 1;
        while (true) {
            String words = scanner.nextLine();
            Pattern pattern = Pattern.compile("[a-zA-Z']+");
            Matcher matcher = pattern.matcher(words);
            if (words.equals("end")) {
                break;
            }
            while (matcher.find()) {
                String word = matcher.group();//слово
                if (hashMap.containsKey(word)) {
                    hashMap.put(word, hashMap.get(word) + 1);
                } else {
                    hashMap.put(word, count);
                }
            }
        }
        Iterator<Map.Entry<String, Integer>> itr = hashMap.entrySet().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
