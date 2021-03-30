package by.it.kaminskii.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] line = {};
    private static int[] count = {};

    private static int pos(String word) {
        for (int i = 0; i < line.length; i++) {
            if (line[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = (matcher.group());
            int p = pos(word);
            if (p >= 0) {
                count[p]++;
            } else {
                int last = line.length;
                line = Arrays.copyOf(line, last + 1);
                line[last] = word;
                count = Arrays.copyOf(count, last + 1);
                count[last] = 1;
            }
        }
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i] + "=" + count[i]);
        }
    }
}