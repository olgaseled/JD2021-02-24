package by.it.levchuk.levchuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.levchuk.levchuk.jd01_06.Poem.text;

public class TaskA2 {
    public static void main(String[] args) {


        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String word = matcher.group();



        }
    }

}
