package by.it.kirichenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String text = new String(Poem.text);
        String[] arrayStringS = text.split("\n");
        int maxLengthString = 0;
        for (String string : arrayStringS) {
            if (maxLengthString < string.length()) {
                maxLengthString = string.length();
            }
        }

        Pattern patternGetWord = Pattern.compile("[\\S]+");
        //Pattern patternGetWord = Pattern.compile("[а-яА-ЯёЁ]+");
        for (int i = 0; i < arrayStringS.length; i++) {
            int posForInsert = 0;
            int beginFind = 0;
            while (arrayStringS[i].length() < maxLengthString) {
                Matcher matcherGetWord = patternGetWord.matcher(arrayStringS[i]);


                if (matcherGetWord.find(beginFind)) {
                    posForInsert = matcherGetWord.end();
                    if (posForInsert < arrayStringS[i].length()) {
                        arrayStringS[i] = arrayStringS[i].substring(0, posForInsert) + ' ' + arrayStringS[i].substring(posForInsert);
                    }
                    beginFind = posForInsert;
                } else {
                    beginFind = 0;
                }
            }
        }
        printArray(arrayStringS);
    }

    private static void printArray(String[] array) {
        for (String value : array) {
            System.out.println(value);
        }
    }
}
