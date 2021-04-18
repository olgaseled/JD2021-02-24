package by.it.runcov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    private static String[] splitText = {};

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        findThreeDot(text);
        splitText = text.toString().split("[.!?]");

        for (int i = 0; i < splitText.length; i++) {
            splitText[i] = splitText[i]
                    .replaceAll("[^а-яА-ЯёЁ]", " ")
                    .replaceAll(" {2,}", " ").trim();
        }

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < splitText.length - 1; i++) {
                String temp;
                if (splitText[i].length() > splitText[i + 1].length()) {
                    temp = splitText[i];
                    splitText[i] = splitText[i + 1];
                    splitText[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        for (String s : splitText) {
            System.out.println(s);
        }
    }



    public static void findThreeDot(StringBuilder text) {
        Pattern pattern = Pattern.compile("\\.{3}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            text.replace(matcher.start(), matcher.end(), "");
        }
    }
}
