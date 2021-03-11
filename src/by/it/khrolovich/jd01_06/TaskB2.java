package by.it.khrolovich.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {

        StringBuilder text = new StringBuilder(Poem.text);

        String s = DeletePoints(text);

        StringBuilder textDelPoints = new StringBuilder(s);
        String s1 = ClearText(textDelPoints);

        StringBuilder textSplit = new StringBuilder(s1);
        String s2 = SplitText(textSplit);

        StringBuilder textSort = new StringBuilder(s2);
        SortText(textSort);
    }

    private static String DeletePoints(StringBuilder text) {
        Pattern pattern = Pattern.compile("\\.{3}");
        Matcher matcher = pattern.matcher(text);
        String s = matcher.replaceAll("");
        return s;
    }

    private static String ClearText(StringBuilder text) {
        Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ.!?]+");
        Matcher matcher = pattern.matcher(text);
        String s = matcher.replaceAll(" ");

        return s;
    }

    private static String SplitText(StringBuilder text) {
        Pattern pattern = Pattern.compile("[.!?] ?");
        Matcher matcher = pattern.matcher(text);
        String s = matcher.replaceAll("\n");

        return s;
    }

    private static void SortText(StringBuilder text) {
        Pattern pattern = Pattern.compile("\\n");
        Matcher matcher = pattern.matcher(text);
        String[] split = pattern.split(text);
        sort(split);
        for (String s : split) {
            System.out.println(s);
        }

    }

    static void sort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1].length() > temp.length()) {
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            arr[j] = temp;
        }
    }
}
