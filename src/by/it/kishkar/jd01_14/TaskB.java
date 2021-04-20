package by.it.kishkar.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(
                        dir(TaskB.class) + "Poem.txt"));
             PrintWriter printWriter = new PrintWriter(
                     new FileWriter(
                             dir(TaskB.class) + "resultTaskB.txt"))
        ) {
            int wordsAmount = 0;
            int marksAmount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\s?[А-Яа-яЁё.?]+\\s?");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find())
                    wordsAmount++;
                Pattern patternP = Pattern.compile("[!.,?:-]+");
                Matcher matcherP = patternP.matcher(line);
                while (matcherP.find())
                    marksAmount++;
            }
            System.out.println("words="+wordsAmount+", punctuation marks="+marksAmount);
            printWriter.println("words="+wordsAmount+", punctuation marks="+marksAmount);



        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
