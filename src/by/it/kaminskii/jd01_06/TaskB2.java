package by.it.kaminskii.jd01_06;

import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        text = text.replace("...","");
//        Pattern splitPat = Pattern.compile("[.?!]");
        String[] sentence = text.split("[.?!]");
        for (int i = 0; i <sentence.length; i++) {
            sentence[i]=sentence[i].replaceAll("[^а-яА-ЯёЁ]+"," ").trim();
            System.out.println(sentence[i]);

        }
    }
}
