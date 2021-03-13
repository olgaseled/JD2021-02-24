package by.it.levchuk.levchuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder strbild = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            int start = matcher.start();
            strbild.setCharAt(start + 3, '#');
            if (matcher.group().length() >= 7) {
                strbild.setCharAt(start + 6, '#');
            }
        }
        System.out.println(strbild);
    }
}
