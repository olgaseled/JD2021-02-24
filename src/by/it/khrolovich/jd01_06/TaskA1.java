package by.it.khrolovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,} ");
        //System.out.println(Poem.text);
        StringBuilder text = new StringBuilder(Poem.text);

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            text.setCharAt(start + 3, '#');
            if ((end - start) > 6) {
                text.setCharAt(start + 6, '#');
            }

        }
        System.out.println(text);
    }
}
