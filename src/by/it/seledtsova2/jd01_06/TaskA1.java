package by.it.seledtsova2.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
TaskA1. В каждом слове текста 4-ю и 7-ю буквы заменить символом #.
 Для слов короче 4 символов корректировку не выполнять. Для слов короче 7 символов заменять только 4-ю букву.
 */
public class TaskA1 {

    public static void main(String[] args) {

        StringBuilder stringBuilder=new StringBuilder(Poem.text);
        Pattern pattern=Pattern.compile("[А-Яа-яЁё]{4,}");
        Matcher matcher= pattern.matcher(Poem.text);
        while (matcher.find()) {
           int start=matcher.start();
           stringBuilder.setCharAt(start+3,'#');
           if (matcher.group().length()>=7) {
               stringBuilder.setCharAt(start + 6, '#');
               System.out.println(stringBuilder);
           }
        }


    }
}
