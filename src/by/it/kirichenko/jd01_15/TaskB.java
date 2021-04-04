package by.it.kirichenko.jd01_15;

import java.io.*;

/**
 * Class delete comments
 */

public class TaskB {
    private static final String TASKB_TXT = "TaskB.txt";
    private static final String TASKB_JAVA = "TaskB.java";

    public static void main(String[] args) {
        String filenameJava = FileNameHelper.getFilePath(TASKB_JAVA, TaskB.class);
        StringBuffer[] stringBuffer = new StringBuffer[5000];

        //extractedTextFromTaskBJava
        int lengthStringBuffer = extractedTextFromTaskBJava(filenameJava, stringBuffer);

        /*delete
        Comments*/
        deleteComments(stringBuffer, lengthStringBuffer);

        /*print File
        In Console*/
        printFileInConsole(stringBuffer, lengthStringBuffer);

        //saveTxtFile
        String filenameTxt = FileNameHelper.getFilePath(TASKB_TXT, TaskB.class);
        saveTxtFile(filenameTxt, stringBuffer, lengthStringBuffer);
    }

    private static void printFileInConsole(StringBuffer[] stringBuffer, int lengthStringBuffer) {
        for (int i = 0; i < lengthStringBuffer; i++) {
            String s = stringBuffer[i].toString();
            System.out.print(s);
        }
    }

    private static void deleteComments(StringBuffer[] stringBuffer, int lengthStringBuffer) {
        for (int i = 0; i < lengthStringBuffer; i++) {
            if (stringBuffer[i].toString().contains("//")) {
                deleteSinglComment(stringBuffer[i]);
            }
            if (stringBuffer[i].toString().contains("/*") && stringBuffer[i].toString().contains("*/")) {
                deleteBigCommentInOneLine(stringBuffer[i]);
            }
            if (stringBuffer[i].toString().contains("/*") && !stringBuffer[i].toString().contains("*/")) {
                deleteFirstLineComment(stringBuffer[i]);
                i = deleteAfterFirstLineComment(stringBuffer, i+1, true);
                deleteLastLineComment(stringBuffer[i]);
            }
        }
    }

    private static void saveTxtFile(String filenameTxt, StringBuffer[] stringBuffer, int lengthStringBuffer) {
        try (PrintWriter out = new PrintWriter(filenameTxt)) {
            for (int i = 0; i < lengthStringBuffer; i++) {
                out.print(stringBuffer[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void deleteLastLineComment(StringBuffer stringBuffer) {
        char[] lineChars = stringBuffer.toString().toCharArray();
        char sleshChar = '/';
        char starChar = '*';
        int indexEndComment = -1;
        for (int j = 0; j < lineChars.length; j++) {
            if ((1 <= j) && (lineChars[j - 1] == starChar) & (lineChars[j] == sleshChar)) {
                indexEndComment = j + 1;
            }
        }

        String oldLine = stringBuffer.toString();
        stringBuffer.setLength(0);
        stringBuffer.append(oldLine.substring(indexEndComment));
    }

    private static int deleteAfterFirstLineComment(StringBuffer[] stringBuffer, int i, boolean delete) {
        for (; !stringBuffer[i].toString().contains("*/"); i++) {
            stringBuffer[i].setLength(0);
            String endString = "";
            if (delete) {
                endString = "";
            } else {
                endString = "\n";
            }
            stringBuffer[i].append(endString);
        }
        int newI = i;
        return newI;
    }

    private static void deleteBigCommentInOneLine(StringBuffer stringBuffer) {
        char[] lineChars = stringBuffer.toString().toCharArray();
        char sleshChar = '/';
        char starChar = '*';
        int indexBeginComment = -1;
        int indexEndComment = -1;
        for (int j = 0; j < lineChars.length; j++) {
            if ((1 <= j) && (lineChars[j - 1] == sleshChar) & (lineChars[j] == starChar)) {
                indexBeginComment = j - 1;
            } else if ((1 <= j) && (lineChars[j - 1] == starChar) & (lineChars[j] == sleshChar)) {
                indexEndComment = j + 1;
            }
        }

        String oldLine = stringBuffer.toString();
        stringBuffer.setLength(0);
        stringBuffer.append(oldLine.substring(0, indexBeginComment) + oldLine.substring(indexEndComment));
    }

    private static void deleteFirstLineComment(StringBuffer stringBuffer) {
        char[] lineChars = stringBuffer.toString().toCharArray();
        char sleshChar = '/';
        char starChar = '*';
        int indexBeginComment = -1;
        for (int j = 0; j < lineChars.length; j++) {
            if ((1 <= j) && (lineChars[j - 1] == sleshChar) & (lineChars[j] == starChar)) {
                indexBeginComment = j - 1;
                break;
            }
        }

        String oldLine = stringBuffer.toString();
        stringBuffer.setLength(0);
        stringBuffer.append(oldLine.substring(0, indexBeginComment) );
    }

    private static void deleteSinglComment(StringBuffer stringBuffer) {
        char[] lineChars = stringBuffer.toString().toCharArray();
        char previoseChar = '/';
        int indexBeginComment = -1;
        for (int j = 0; j < lineChars.length; j++) {
            if (lineChars[j] == previoseChar) {
                indexBeginComment = j;
                break;
            }
        }
        //delete comment "//"
        String oldLine = stringBuffer.toString();
        stringBuffer.setLength(0);
        stringBuffer.append(oldLine.substring(0, indexBeginComment) + "\n");
               /* char[] last = arrayLinesFromTaskBJava[i]
                        .substring(
                                arrayLinesFromTaskBJava[i]
                                        .length() - 76)
                        .toCharArray();
                System.out.println((int) last[0]);*/
    }

    private static int extractedTextFromTaskBJava(String filename, StringBuffer[] stringBuffer) {
        int i = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer[i++] = new StringBuffer(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
}
