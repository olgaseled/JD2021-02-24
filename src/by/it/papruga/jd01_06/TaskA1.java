package by.it.papruga.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder builder = new StringBuilder(Poem.text);

        System.out.println(Poem.text);



    }


}
