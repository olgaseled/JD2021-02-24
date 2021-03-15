package by.it.khrolovich.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {

        String text = Poem.text;
        text = text.replace("...", "");

        String sentences = text.replaceAll("[^а-яА-ЯёЁ.!?]+", " ");
        String[] split = sentences.split("\\s*[.!?]\\s*");
        sortText(split);
        for (String s : split) {
            System.out.println(s);
        }
    }

    static void sortText(String[] arr) {
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
