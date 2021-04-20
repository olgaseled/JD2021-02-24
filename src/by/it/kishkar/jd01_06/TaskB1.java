package by.it.kishkar.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(Poem.text);

        Pattern pattern = Pattern.compile("(?U)\\b[бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ]\\w+");
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
           String k=matcher.group();
           StringBuffer kk=new StringBuffer(k);
            kk.reverse(); //перевернули
            Pattern patternrev = Pattern.compile("(?U)\\b[ауоыиэяюёе]\\w+");
            Matcher matcherrev=patternrev.matcher(kk);
            //Сейчас конец=начало, отсортировали начало только по гласным
            while (matcherrev.find()) {
              String res=matcherrev.group();
              StringBuffer result=new StringBuffer(res);
              result.reverse(); //перевернули результат выборки в исходное

                System.out.println(result);

            }

            }
        }
}

