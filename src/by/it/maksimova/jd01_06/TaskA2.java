package by.it.maksimova.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskA2 {
    private static String [] words = {};
    private static int [] counts = {};
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            processOneWord(word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d", words[i], counts[i]);
            System.out.println();
        }
    }

    private static void processOneWord(String word) {
        for (String currentWord : words) {
            if (currentWord.equals(word)) {
//                counts[i]=counts[i]+1;
                return;
            }

        }
        words= Arrays.copyOf(words,words.length+1);
        counts= Arrays.copyOf(counts,words.length+1);
        words[words.length-1]=word;
        counts[counts.length-1]=1;

    }
}

