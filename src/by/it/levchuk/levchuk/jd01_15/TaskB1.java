package by.it.levchuk.levchuk.jd01_15;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.io.*;

/**
 * the file should have
 * 2 single-line and 2 multi-line comments,
 * and javaDoc
 */

public class TaskB1 extends Conditions {


    public static void main(String[] args) {//start of the program execution
        String roadToJava = FileNameHelper.getFilePath(JAVA_TASK, TaskB.class);
        String roadToTxt = FileNameHelper.getFilePath(TXT_TASK, TaskB.class);
        StringBuffer[] strBuf = new StringBuffer[MAX];
        int temp = extracted(roadToJava, strBuf);
        delComments(strBuf, temp);
        printCodeToConsole(strBuf,temp);
        saveCodeToTxtFile(roadToTxt,strBuf,temp);
    }

    private static void saveCodeToTxtFile(String roadToTxt, StringBuffer[] strBuf, int temp) {
        try (PrintWriter outCode = new PrintWriter(roadToTxt)) {//writing code to a txt file
            for (int i = 0; i < temp; i++) {
                outCode.print(strBuf[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printCodeToConsole(StringBuffer[] strBuf, int temp) {
        for (int i = 0; i < temp; i++) { /*writing code
                                          in console*/
            String code = strBuf[i].toString();
            System.out.println(code);
        }
    }


    private static void delComments(StringBuffer[] strBuf, int temp) {/*Delete
                                                                      comments*/
        for (int i = 0; i < temp; i++) {
            if (strBuf[i].toString().contains("/*") && !strBuf[i].toString().contains("*/")) {
                delJavaDocComments(strBuf[i]);
                i = delStartLine(strBuf, i + 1, true);
                delStopLine(strBuf[i]);
            }
            if (strBuf[i].toString().contains("//")) {
                delSingleComments(strBuf[i]);
            }
            if (strBuf[i].toString().contains("/*") && strBuf[i].toString().contains("*/")) {
                delBlockComments(strBuf[i]);
            }
        }
    }
    private static int extracted(String roadToJava, StringBuffer[] strBuf) {
        int i = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(roadToJava))) {
            String line = "";
            if ((line = bufferedReader.readLine()) != null) {
                strBuf[i++] = new StringBuffer(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
}

