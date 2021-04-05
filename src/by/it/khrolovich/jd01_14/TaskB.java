package by.it.khrolovich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String TASK_B_TXT = "Poem.txt";
    private static final String RESULT_B_TXT = "resultTaskB.txt";

    public static void main(String[] args) {
        String txtFile = getFilePath(TASK_B_TXT, TaskB.class);
        StringBuilder textPoem = readFromFile(txtFile);
        int countOfWords = CountOfItem(textPoem, "[а-яА-ЯёЁ]+");
        int countOfPunctuation = CountOfItem(textPoem, "[.,?!:;]");
        String s = "words=" + countOfWords + ", punctuation marks=" + countOfPunctuation;
        System.out.printf("words=%d, punctuation marks=%d", countOfWords, countOfPunctuation);
        String txtFileResult = getFilePath(RESULT_B_TXT, TaskB.class);
        WriteToFile(txtFileResult, s);
    }

    private static StringBuilder readFromFile(String txtFile) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(txtFile))) {
            String delimiter = " ";
            while (bufferedReader.ready()) {
                text.append(bufferedReader.readLine()).append(delimiter);
            }
            System.out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;

    }

    private static int CountOfItem(StringBuilder textPoem, String exp) {
        Pattern pattern = Pattern.compile(exp);
        Matcher matcher = pattern.matcher(textPoem);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static void WriteToFile(String txtFileResult, String s) {
        try (PrintWriter printWriter = new PrintWriter(txtFileResult)) {
            printWriter.write(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(String filename, Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName() //by.it._tasks_.jd01_14.TaskA
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + filename;
    }
}

