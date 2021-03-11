package by.it.belazarovich.jd01_06;

import java.util.Arrays;


public class TaskB1 {
    public static void main(String[] args) {
        String s;
        s = Poem.text;

        String letters = "БВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфхцчшщ";
        Arrays.stream(s.split("\\s+"))
                .filter(x -> letters.contains(x.substring(0,1)))

                .forEach(System.out::println);
    }
}
/*
  //      String letters = "БВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфхцчшщ";
        Pattern pattern = Pattern.compile("БВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфхцчшщ");
        for (String s : wordArray) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                System.out.println(word);
 */
