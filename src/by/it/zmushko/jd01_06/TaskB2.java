package by.it.zmushko.jd01_06;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] mySplitText = {};

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        findThreeDot(text);
        mySplitText = text.toString().split("[.!?]");

        for (int i = 0; i < mySplitText.length; i++) {
            mySplitText[i] = mySplitText[i].replaceAll("[^а-яА-ЯёЁ]", " ").replaceAll(" {2,}", " ").trim();
        }

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < mySplitText.length - 1; i++) {
                String temp;
                if (mySplitText[i].length() > mySplitText[i + 1].length()) {
                    temp = mySplitText[i];
                    mySplitText[i] = mySplitText[i + 1];
                    mySplitText[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        for (String s : mySplitText) {
            System.out.println(s);
        }
    }



    public static void findThreeDot(StringBuilder text) {
        Pattern pattern = Pattern.compile("\\.{3}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            text.replace(matcher.start(), matcher.end(), "");
        }
    }


}
