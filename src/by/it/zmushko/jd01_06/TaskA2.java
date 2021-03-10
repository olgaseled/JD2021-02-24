package by.it.zmushko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words = {};
    private static int[] counts = {};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            processOneWord(word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s = %d\n", words[i], counts[i]);
        }
    }

    private static void processOneWord(String word) {
        int pos = pos(word);
        for (int i = 0; i < words.length; i++) {
            if (pos >= 0) {
                counts[pos]++;
            } else {
                int newLength = words.length - 1;
                words = Arrays.copyOf(words, newLength);
                counts = Arrays.copyOf(counts, newLength);
                words[words.length - 1] = word;
                counts[counts.length - 1] = 1;
            }
        }
    }

    public static int pos(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

}


