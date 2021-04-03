package by.it.maksimova.jd01_14;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    public static final String POEM_TXT = "Poem.txt";

    private static String dir() {
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = TaskB.class.getName().replace(TaskB.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dir() + POEM_TXT))) {
            String line = reader.readLine();
            getTotalWords(line);
            getPunctuationMarks(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getTotalWords(String line) {
        int totalWords = 0;
        while (line != null) {
            Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                totalWords++;
            }
        }
    }

    private static void getPunctuationMarks(String line) {
        int totalPunctuationMarks = 0;
        while (line != null) {
            Pattern pattern = Pattern.compile("[!?.,:;]+");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                totalPunctuationMarks++;
            }
        }

    }
}

