package by.it.savchenko.jd01_06;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {


    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?U)\\b[бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ]\\w+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String a = matcher.group();
            StringBuilder b = new StringBuilder(a);
            b.reverse();

            Pattern pattern1 = Pattern.compile("(?U)\\b[ауоыиэяюёе]\\w+");
            Matcher matcher1 = pattern1.matcher(b);
            while (matcher1.find()) {
                String c = matcher1.group();
                StringBuilder d = new StringBuilder(c);
                d.reverse();
                System.out.println(d);
            }
        }
    }

        private static boolean checkOneWord (String word){
            String votes = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
            char first = word.toLowerCase().charAt(0);
            char last = word.toLowerCase().charAt(word.length() - 1);
            boolean firstOk = votes.indexOf(first) < 0;
            boolean lastOk = votes.indexOf(last) >= 0;
            return firstOk && lastOk;

        }
    }

