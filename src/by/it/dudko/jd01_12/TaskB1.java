package by.it.dudko.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TaskB1 {

    private final Map<String, Integer> itemMap = new HashMap<>();

    void addItem(String key) {
        itemMap.put(key, (itemMap.containsKey(key) ? itemMap.get(key) + 1 : 1));
    }

    void printCollection() {
        for (Map.Entry<String, Integer> mapItem : itemMap.entrySet()) {
            System.out.printf("%s=%d\n", mapItem.getKey(), mapItem.getValue());
        }
    }

    public static void main(String[] args) {
        TaskB1 wordsMap = new TaskB1();
        Scanner sc = new Scanner(System.in);
        for (String sentence = ""; ; ) {
            sentence = sc.nextLine();
            if (sentence.trim().equals("end"))
                break;
            String[] words = sentence.split("[^\\w']");
            for (String word : words) {
                if (word.equals(""))
                    continue;
                wordsMap.addItem(word);
            }
        }
        wordsMap.printCollection();
    }



}
