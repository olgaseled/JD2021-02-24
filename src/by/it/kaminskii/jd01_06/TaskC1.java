package by.it.kaminskii.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    static String text = Poem.text;
    static String[] sent = text.split("[\n]");
    static int position=1;


    public static void main(String[] args) {

        int longs = 0;
        for (int i = 0; i < sent.length; i++) {
            if (sent[i].length() > longs) {
                longs = sent[i].length();
            }
        }
        for (int i = 0; i < sent.length; i++) {
            StringBuffer search = new StringBuffer(sent[i]);
            Pattern pattern = Pattern.compile("[\\-^А-Яа-яёЁ]*\\p{Blank}+");
            Matcher matcher = pattern.matcher(search);
            position = 0;
            while (search.length() < longs) {
                if (position >= 0 && position < 36) {
                    if (matcher.find((position))) {
                        position = matcher.end();
                        search.insert(position, " ");
                        position++;
                    }

                else{
                        position = 0;
                    }
                }
            }
            sent[i] = search.toString();
        }
        for (int i = 0; i < sent.length; i++) {
            System.out.println(sent[i]);
        }
    }
}

//                else if (position >= 36){
//                    position = 0;
//                }
//                else {
//                    matcher.find();
//                    position=matcher.end();
//                    search.insert(position, " ");
//                    System.out.print(search);
//                    System.out.println(position);
//                }
