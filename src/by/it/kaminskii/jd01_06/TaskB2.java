package by.it.kaminskii.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        text = text.replace("...", "");
//        Pattern splitPat = Pattern.compile("[.?!]");
        String[] sentence = text.split("[.?!]");
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sentence[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }
        for (int i = 0; i < sentence.length - 1; i++) {
            for (int j = i ; j < sentence.length; j++) {
                if(sentence[i].length() > sentence[j].length()) {
                    String cup = sentence[i];
                    sentence[i] = sentence[j];
                    sentence[j] = cup;
                }

            }
        }
        for (int i = 0; i < sentence.length; i++) {
            System.out.println(sentence[i]);

        }
    }
}
