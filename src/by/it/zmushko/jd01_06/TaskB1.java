package by.it.zmushko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static final String liter = "ауоыиэяюёеАУОЫИЭЯЮЕЁ";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        StringBuilder text = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String findWord = matcher.group();
            if (checkWord(findWord)){
                System.out.println(findWord);
            }
        }

    }

    public static boolean checkWord(String word) {
        return liter.indexOf(word.charAt(0)) < 0 && liter.indexOf(word.charAt(word.length() - 1)) >= 0;
    }
}
