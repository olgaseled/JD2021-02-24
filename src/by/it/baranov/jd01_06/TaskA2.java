package by.it.baranov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    public static  String[] w={};
    public static  int[] count={};


    public static int pos (String word){
        for (int i=0; i<w.length;i++) {
            if (w[i].equals (word));
        return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("[a-яА-ЯёЁ]+");
        Matcher matcher= pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int p = pos(word);
            if (p >= 0) {
                count[p]++;
            } else {
                int last = w.length;
                w = Arrays.copyOf(w, 1 + last);
                w[last] = word;
                count = Arrays.copyOf(count, last+1);
                count[last] = 1;
            }
        }
        for (int i=0;i<w.length;i++) {
            System.out.println(w[i] + "=" + count[i]);
        }

            }

    }





