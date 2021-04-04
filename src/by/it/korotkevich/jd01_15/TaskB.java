package by.it.korotkevich.jd01_15;

import javax.sql.rowset.serial.SerialStruct;
import java.io.*;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static final String USER_DIR = "user.dir";
    public static final String SRC_BY_IT_KOROTKEVICH = "/src/by/it/korotkevich/";
    public static final String JD_01_15 = "jd01_15";
    public static final String TASK_B_JAVA = "TaskB.java";
    public static final String TASK_B_TXT = "TaskB.txt";
    /*
    1. прочитать текст программы в StringBuilder
    2. удалить все комментарии
    3. вывести в консоль
    4. вывести в txt
     */

    public static void main(String[] args) {
        // задаем путь к файлу программы
        String src = System.getProperty(USER_DIR) + SRC_BY_IT_KOROTKEVICH;
        String sourceFilePath = src + JD_01_15 + File.separator + TASK_B_JAVA;
        String resultTxtPath = src + JD_01_15 + File.separator + TASK_B_TXT;
        // удаляем комментарии
        String textWithoutComments = readAndRemoveComments(sourceFilePath);
        System.out.println(textWithoutComments);
        printToTxtFile(textWithoutComments, resultTxtPath);
    }

    /**
     * Reads .java file and removes all comments and javadoc
     *
     * @param sourceFilePath .java path
     * @return text without comments
     */
    private static String readAndRemoveComments(String sourceFilePath) {
        Pattern commentPattern = Pattern.compile("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)|(//.*)");
        /*
        Удаляет три типа комментариев:
        однострочные;
        многострочные;
        javadoc.
         */
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFilePath))) {
            String oneLine = bufferedReader.readLine();
            StringBuilder fullProgramText = new StringBuilder();
            String textWithoutComments = null;
            while (oneLine != null) {
                fullProgramText
                        .append(oneLine)
                        .append("\n");
                oneLine = bufferedReader.readLine();
            }
            Matcher matcher = commentPattern.matcher(fullProgramText);
            while (matcher.find()) {
                textWithoutComments = matcher.replaceAll("");
            }
            return textWithoutComments;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToTxtFile(String textWithoutComments, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(fileName))){
            bufferedWriter.write(textWithoutComments);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
