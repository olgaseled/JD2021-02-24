package by.it.kirichenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static final String votes = "уеэоаыяиюёУЕЫАОЭЯИЮЁ";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (checkOneWord(word)){
                System.out.println(word);
            }
        }
    }

    private static boolean checkOneWord(String word) {
        return votes.indexOf(word.charAt(0)) < 0
                && votes.indexOf(word.charAt(word.length() - 1)) >= 0;
    }
}
