package by.it.dudko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words = {};
    private static int[] counters = {};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            String word = matcher.group();
            processWord(word);
        }

        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], counters[i]);
        }
    }

    private static void processWord(String word) {
        if (0 == words.length) {
            words = Arrays.copyOf(words, 1);
            counters = Arrays.copyOf(counters, 1);
            words[0] = word;
            counters[0] = 1;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                counters[i]++;
                return;
            }
        }
        int appendIndex = words.length;
        words = Arrays.copyOf(words, words.length+1);
        counters = Arrays.copyOf(counters, words.length);
        words[appendIndex] = word;
        counters[appendIndex] = 1;
    }
}
