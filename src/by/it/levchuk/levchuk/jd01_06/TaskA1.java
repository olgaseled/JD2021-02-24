package by.it.levchuk.levchuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.levchuk.levchuk.jd01_06.Poem.text;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder builder = new StringBuilder(text);
        Matcher matcher=pattern.matcher(builder);
        while (matcher.find()){
            int start = matcher.start();
            int end=matcher.end();


        }

        System.out.println(text);

    }
}
