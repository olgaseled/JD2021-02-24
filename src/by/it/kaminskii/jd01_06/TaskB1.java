package by.it.kaminskii.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {


    public static void main(String[] args) {
//        String text = Poem.text;
//        String[] textWord = text.split(" ");
//        for (int i = 0; i < textWord.length; i++) {
//            String word = textWord[i];
//            if (checking(word)==true){
//                System.out.println(word);
//
//            }
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            if (checking(matcher.group())) {
                String finish = matcher.group();
                System.out.println(finish);
            }
        }
    }

    private static boolean checking(String words) {
        String vowels = "аиеёоуыэюя";
        char first = words.toLowerCase().charAt(0);
        char last = words.toLowerCase().charAt(words.length() - 1);
        boolean firstcheck = vowels.indexOf(first) < 0;
        boolean lastcheck = vowels.indexOf(last) >= 0;
        return firstcheck && lastcheck;
    }
}
//    private static void checking(String words){
