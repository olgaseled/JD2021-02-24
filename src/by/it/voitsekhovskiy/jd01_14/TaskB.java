package by.it.voitsekhovskiy.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String text = getText();
        String resultStr = resultString(text);
        stringToTxt(resultStr);
    }

    private static void stringToTxt(String str) {
        try (
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter(dir(TaskB.class) + "resultTaskB.txt")
                )
        ) {
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String resultString(String txt) {
        String words = "[а-яА-ЯёЁ]+";
        int countWords = counting(txt, words);
        String marks = "[-.,:!;]{1,3}";
        int countMarks = counting(txt, marks);
        String resultString = String.format("words=%d punctuation marks=%d", countWords, countMarks);
        System.out.println(resultString);
        return resultString;
    }

    private static int counting(String txt, String marks) {
        Pattern pt = Pattern.compile(marks);
        Matcher match = pt.matcher(txt);
        int count = 0;
        while (match.find()) {
            count = count + 1;
        }
        return count;
    }

    private static void countingMarks(String txt) {

    }

    private static String getText() {
        StringBuilder sb = new StringBuilder();
        try (
                BufferedReader isRead = new BufferedReader(
                        new FileReader(dir(TaskB.class) + "Poem.txt")
                )
        ) {
            String line;
            while ((line = isRead.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
        return sb.toString();
    }


    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }
}
