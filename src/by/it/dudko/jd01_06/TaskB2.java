package by.it.dudko.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        StringBuilder poem = new StringBuilder(Poem.text);
        replaceEllipsis(poem);
        String[] sentences = splitTextToSentences(poem);
        cleanSentences(sentences);
        sortSentencesByLength(sentences);
        // Helper.printEachStringLength(sentences);
        System.out.print(String.join("\n", sentences));
    }

    private static void sortSentencesByLength(String[] sentences) {
        Arrays.sort(sentences, new Comparator<String>() {
            public int compare(String one, String two) {
                int returnValue = one.length() - two.length();
                if (returnValue == 0) {
                    returnValue = one.compareToIgnoreCase(two);
                }
                return returnValue;
            }
        });
    }


    private static void cleanSentences(String[] sentences) {
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = String.join(" ", sentences[i].trim().split("[^а-яА-ЯёЁ]+"));
        }
//        String[] cleanedSentences = new String[sentences.length];
//        int index = 0;
//        for (String item : sentences) {
//            cleanedSentences[index++] = String.join(" ", item.trim().split("[^а-яА-ЯёЁ]+"));
//        }
//        return cleanedSentences;
    }


    private static String[] splitTextToSentences(StringBuilder text) {
        return text.toString().split("[!?\\.]");
    }

    private static void replaceEllipsis(StringBuilder text) {
        Pattern pattern = Pattern.compile("\\.{2,}");
        Matcher matcher = pattern.matcher(text);
        int searchRangeStart = 0;
        while (matcher.find(searchRangeStart)) {
            // replace ellipsis
            text.replace(matcher.start(), matcher.end(), " ");
            searchRangeStart = matcher.end();
        }
    }


}
