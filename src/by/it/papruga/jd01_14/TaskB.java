package by.it.papruga.jd01_14;


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

        try (BufferedReader reader = new BufferedReader
                (new FileReader(dir(TaskB.class) + "Poem.txt"));

        PrintWriter out = new PrintWriter
                (new FileWriter
                (dir(TaskB.class) + "resultTaskB.txt"))

        ) {

            String line = reader.readLine();

            StringBuffer text = new StringBuffer();

            while (line != null) {

                text.append(line + "\n");
                line = reader.readLine();
            }

            int wordsCount = 0;
            int marksCount = 0;


            Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                wordsCount++;
            }

            Pattern pattern2 = Pattern.compile("[-:,.!]+");
            Matcher matcher2 = pattern2.matcher(text);
            while (matcher2.find()) {
                marksCount++;
            }


            System.out.println("words=" + wordsCount + ", punctuation marks=" + marksCount);
            out.println("words=" + wordsCount + ", punctuation marks=" + marksCount);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
