package by.it.savchenko.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = TaskB.class.getName().replace(TaskB.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(dir() + "Poem.txt"));

             PrintWriter printWriter = new PrintWriter(
                     new FileWriter(dir() + "resultTaskB.txt"))
        ) {
            String line = bufferedReader.readLine();
            StringBuffer text = new StringBuffer();

            while (line != null) {
                text.append(line).append("\n");
                line = bufferedReader.readLine();
            }

            int words = 0;
            int marks = 0;

            Pattern pattern1 = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher1 = pattern1.matcher(text);
            while (matcher1.find()) {
                words++;
            }

            Pattern pattern2 = Pattern.compile("[-:,.!]+");
            Matcher matcher2 = pattern2.matcher(text);
            while ((matcher2.find())) {
                marks++;
            }

            System.out.println("words=" + words + ", punctuation marks=" + marks);
            printWriter.println("words=" + words + ", punctuation marks=" + marks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
