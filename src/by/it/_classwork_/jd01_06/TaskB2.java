package by.it._classwork_.jd01_06;

import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        //1. del ...
        text = text.replace("...", "");
        //2. split
        String[] sentences = text.split("[.?!]");
        //3. del non-letters
        for (int i = 0; i < sentences.length; i++) {
            sentences[i]=sentences[i]
                    .replaceAll("[^а-яА-ЯёЁ]+"," ")
                    .trim();
            System.out.println(sentences[i]);
        }

    }
}
