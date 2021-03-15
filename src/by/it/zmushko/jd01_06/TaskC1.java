package by.it.zmushko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    private static String[] myMas = {};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[\\n]");
        Matcher matcher = pattern.matcher(Poem.text);
        myMas = Poem.text.split("[\\n]");
        int max = 0;
        for (int i = 0; i < myMas.length; i++) {
            if (max < myMas[i].length()) {
                max = myMas[i].length();
            }
        }

        for (int i = 0; i < myMas.length; i++) {
            while (myMas[i].length() != max) {
            }
        }
        for (String myMa : myMas) {
            System.out.println(myMa);
        }
    }
}
