package by.it.maksimova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TaskB1.Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся гласной буквой
public class TaskB1 {

    private static final String votes="уеэоаыяиюёУЕЫАОЭЯИЮЁ"; //гласные

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            if (checkWord(word))
                System.out.println(word);
        }
    }

    private static boolean checkWord (String word) { //какое-то слово
        String fistLetter = word.substring(0, 1); //первая буква
        String lastLetter = word.substring(word.length() - 1); //последняя буква
        boolean firstOk = !votes.contains(fistLetter); //проверим, что первой нет в гласных
        boolean lastOk = votes.contains(lastLetter); //проверим, что последняя есть в гласных
        return firstOk && lastOk;
    }
}


