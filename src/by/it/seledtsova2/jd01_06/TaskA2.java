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
    public static void main(String[] args) {
        int a=0;
        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");

        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String words = matcher.group();
            System.out.print(words+" ");


            }
                  }
    }



