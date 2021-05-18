package by.it.zadachaKniga;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
" Java — строго типизированный объектно-ориентированный язык программирования общего назначения. "
 */
public class Zad27 {
    public static void main(String[] args) {
        int count=0;
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();

        Pattern pattern=Pattern.compile("[А-Яа-яЁё]");
        Matcher matcher= pattern.matcher(string);
        while (matcher.find()) {

        }
            System.out.println(string);

        }

    }


