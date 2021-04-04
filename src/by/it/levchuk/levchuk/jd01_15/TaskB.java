package by.it.levchuk.levchuk.jd01_15;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * the file should have
 * 2 single-line and 2 multi-line comments,
 * and javaDoc
 */

public class TaskB {

    private static final String JAVA_TASK = "TaskB.java";
    private static final String TXT_TASK = "TaskB.txt";

    public static void main(String[] args) { //start of the program execution
        String roadToJava = FileNameHelper.getFilePath(JAVA_TASK, TaskB.class);
        String roadToTxt = FileNameHelper.getFilePath(TXT_TASK, TaskB.class);

        /*Delete
        comments*/
        String codeWithoutComments = delComments(fileToString(roadToJava));
        /*conclusion
        in console*/
        System.out.println(codeWithoutComments);
        //writing code to a txt file
        printInTxt(roadToTxt, codeWithoutComments);
    }

    private static String delComments(String text) {
        text = text.replaceAll("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)|(//.*)", "");
        return text;
    }

    private static String fileToString(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Files.lines(Paths.get(path))
                    .forEach(el -> stringBuilder.append(el).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private static void printInTxt(String path, String newText) { //writing code to a txt file
        try {
            Files.write(Paths.get(path), newText.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
