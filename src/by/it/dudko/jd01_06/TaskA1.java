package by.it.dudko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        char replaceChar = '#';
        StringBuilder poem = new StringBuilder(Poem.text);
        String regex = "[а-яА-ЯёЁ]{4,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(poem);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            poem.setCharAt(start + 3, replaceChar);
            if (end - start > 6) {
                poem.setCharAt(start + 6, replaceChar);
            }
        }
        System.out.println(poem);
    }
}
