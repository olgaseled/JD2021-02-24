package by.it.belazarovich.jd01_06;




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

    /**
     * @param word
     * @return
     */
    private static boolean checkOneWord (String word){
        String votes = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
        char first = word.toLowerCase().charAt(0);
        char last = word.toLowerCase().charAt(word.length() - 1);
        boolean firstOk = votes.indexOf(first) < 0;
        boolean lastOk = votes.indexOf(last) >= 0;
        return firstOk && lastOk;

    }
}
 /*
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

