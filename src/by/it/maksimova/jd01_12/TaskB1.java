package by.it.maksimova.jd01_12;

import java.util.*;

public class TaskB1 {

    public static void main(String[] args) {

        HashMap<String, Integer> numberOfWords = new HashMap<>();
// ввести с консоли текст 100 и более слов
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String words = scanner.nextLine();
            if (words.equals("end")) {
                break;
            }
// Для каждого слова с помощью коллекций подсчитать частоту его встречаемости
            for (String word : words.split("[,.:; ]")) {
                numberOfWords.put(word, numberOfWords.getOrDefault(word, 0)+1);
            }
        }
        System.out.println(numberOfWords);
    }
}


