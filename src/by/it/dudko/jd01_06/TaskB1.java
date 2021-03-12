package by.it.dudko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    final static String vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";

    public static void main(String[] args) {
        Pattern wordPattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = wordPattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (customWordCheck(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean customWordCheck(String word) {
        return vowels.indexOf(word.charAt(0)) < 0 &&
                vowels.indexOf(word.charAt(word.length() - 1)) >= 0;
    }
}
