package by.it.papruga.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static final String votes = "уеэоаыяиюёУЕЫАОЭЯИЮЁ";

    public static void main(String[] args) {

        boolean result = chekOneWord("Вася");
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find ()) {

            if (chekOneWord(matcher.group()) == result) {
                System.out.println(matcher.group());
            }
        }
    }

    private static boolean chekOneWord(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        return votes.indexOf(first)<0 && votes.indexOf(last)>=0;
    }


}
