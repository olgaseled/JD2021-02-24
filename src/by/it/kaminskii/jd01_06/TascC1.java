package by.it.kaminskii.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TascC1 {
    static String text = Poem.text;
    static String[] sentence = text.split("[\n]");
    private static int last=0;

    public static void main(String[] args) {

        int longs = 0;
        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i].length() > longs) {
                longs = sentence[i].length();
            }
        }
        for (int i = 0; i < sentence.length; i++) {
            StringBuffer search =new StringBuffer(sentence[i]);
            while (search.length() < longs) {

                Pattern pattern = Pattern.compile("\\p{Blank}*[А-Яа-яёЁ]*\\p{Blank}{1}");
                Matcher matcher = pattern.matcher(search);
                if (last > 0 && last <36 ) {
                    if (matcher.find((0+last))) ;
                    last = matcher.end();
                    search.insert(last, " ");
                }
                else if (last >= 36){
                    last = 0;
                }
                else {
                    matcher.find();
                    last=matcher.end();
                    search.insert(last, " ");
                    System.out.print(search);
                    System.out.println(last);
                }

            }
            sentence[i] = search.toString();
        }
        for (int i = 0; i < sentence.length; i++) {
            System.out.println(sentence[i]+ "yeah");
        }
    }
}


