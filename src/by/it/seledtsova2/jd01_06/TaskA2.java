package by.it.seledtsova2.jd01_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Определить, сколько раз повторяется в тексте каждое слово,
которое встречается в нем, используя массивы. Вывести результаты на консоль в формате слово=повторы
 */
public class TaskA2 {

    private static String [] words=new String[0];
    private static int [] count=new int[0];

private static int positionInWord (String word) {
    for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word))
            return i;
        }
        return -1;
    }



    public static void main(String[] args) {
        int a=0;
        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String words = matcher.group();
            int pos = positionInWord(words);
            if (pos >= 0) {
                count[pos]++;
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]+" ="+count[i]);

        }
     }

    }



