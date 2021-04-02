package by.it.levchuk.levchuk.jd01_14;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = TaskB.class.getName()
                .replace(TaskB.class.getSimpleName(), "")
                .replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader
                (new FileReader(dir() + "Poem.txt"));

             PrintWriter out = new PrintWriter
                     (new FileWriter
                             (dir() + "resultTaskB.txt"))
        ) {
            String line = reader.readLine();

            StringBuffer text = new StringBuffer();

            while (line != null) {

                text.append(line).append("\n");
                line = reader.readLine();
            }

            int words = 0;
            Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                words++;
            }

            int marks = 0;
            Pattern pattern2 = Pattern.compile("[-:,.!]+");
            Matcher matcher2 = pattern2.matcher(text);
            while (matcher2.find()) {
                marks++;
            }

            System.out.println("words=" + words + ", punctuation marks=" + marks);
            out.println("words=" + words + ", punctuation marks=" + marks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
