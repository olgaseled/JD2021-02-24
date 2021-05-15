package by.it.zadachaKniga;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad26 {
    //Я ты мы вы !,!.,? Ответ 6
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        String stringWord = scanner.nextLine();
        Pattern pattern = Pattern.compile("[-+/*!?.,]");
        Matcher matcher = pattern.matcher(stringWord);
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);

    }
}
