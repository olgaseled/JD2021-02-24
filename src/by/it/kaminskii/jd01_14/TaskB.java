package by.it.kaminskii.jd01_14;/* created by Kaminskii Ivan
 */

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(
                        dir(TaskB.class) + "Poem.txt"));
             PrintWriter out2 = new PrintWriter(
                     new FileWriter(
                             dir(TaskA.class) + "resultTaskB.txt"))
        ) {
            int wordsCol = 0;
            int marksCol =0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\s?[А-Яа-яЁё.?]+\\s?");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) wordsCol++;
                Pattern patternP = Pattern.compile("[!.,?:-]+");
                Matcher matcherP = patternP.matcher(line);
                while (matcherP.find()) marksCol++;
                System.out.println(line+marksCol);
            }
                System.out.println("words="+wordsCol+", punctuation marks="+marksCol);
                out2.println("words="+wordsCol+", punctuation marks="+marksCol);



            } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    }
