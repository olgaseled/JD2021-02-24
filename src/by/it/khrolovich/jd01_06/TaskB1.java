package by.it.khrolovich.jd01_06;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static final String votes = "аоуеяиюэыё";
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String CurrentWord = matcher.group();
            if (checkOneWord(CurrentWord)){
                System.out.println(CurrentWord);
            }

        }
    }

    private static boolean checkOneWord(String word) {
        char first = word.toLowerCase().charAt(0);
        char last = word.toLowerCase().charAt(word.length()-1);
        return votes.indexOf(first)<0 && votes.indexOf(last)>=0;
    }
}
