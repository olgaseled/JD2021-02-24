package by.it.levchuk.levchuk.jd01_15;

/*crash-noobik
Liauchuk Aliaksandr*/

/**
 * the file should have
 * 2 single-line and 2 multi-line comments,
 * and javaDoc
 */

public class TaskB {

    public static final String JAVA_TASK = "TaskB.java";
    public static final String TXT_TASK = "TaskB.txt";

    public static void main(String[] args) { //start of the program execution
        String roadToJava = FileNameHelper.getFilePath(JAVA_TASK, TaskB.class);
        String roadToTxt = FileNameHelper.getFilePath(TXT_TASK, TaskB.class);

    }
}
