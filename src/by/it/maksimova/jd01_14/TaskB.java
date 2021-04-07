package by.it.maksimova.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    public static final String POEM_TXT = "Poem.txt";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";

    private static String dir(Class<?> cl) {
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = TaskB.class.getName().replace(TaskB.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(dir(TaskB.class) + POEM_TXT));
             PrintWriter writer = new PrintWriter(new FileWriter(dir(TaskB.class) + RESULT_TASK_B_TXT))) {

            String line = reader.readLine();
            int totalWords = 0;
            int totalPunctuationMarks = 0;
           while (line!=null) {
               Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
               Matcher matcher = pattern.matcher(line);
               while (matcher.find()) {
                   totalWords++;
               }
                Pattern pattern1 = Pattern.compile("[!?.,:;-]+");
                Matcher matcher1 = pattern1.matcher(line);
                while (matcher1.find()) {
                    totalPunctuationMarks++;
                } line= reader.readLine();

            }
           System.out.printf("words=%s, punctuation marks=%s", totalWords, totalPunctuationMarks);
            writer.printf("words=%s, punctuation marks=%s", totalWords, totalPunctuationMarks);

           }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}



