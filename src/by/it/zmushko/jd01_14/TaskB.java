package by.it.zmushko.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String TASK_B_TXT = "Poem.txt";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String dataPathTaskB = getFilePath(TASK_B_TXT, TaskB.class);
        String txtPath = getFilePath(RESULT_TASK_B_TXT, TaskB.class);
        System.out.println(dataPathTaskB);
        System.out.println(txtPath);
        String str = "";
        consoleWrite(dataPathTaskB, str);
        writeInTxtFile(dataPathTaskB, txtPath, str);
    }

    private static void writeInTxtFile(String dataPathTaskB, String txtPath, String str) throws FileNotFoundException {
        try (PrintWriter write = new PrintWriter(txtPath)) {
            write.println("words=" + getCountWords(replaceFileTxtInString(dataPathTaskB, str)));
            write.println("marks=" + getCountPunctuation(replaceFileTxtInString(dataPathTaskB, str)));
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    private static void consoleWrite(String dataPathTaskB, String str) throws FileNotFoundException {
        str = replaceFileTxtInString(dataPathTaskB, str);
        System.out.println(str);
        int countWords = getCountWords(str);
        int countPunctuation = getCountPunctuation(str);
        System.out.println("words=" + countWords);
        System.out.println("marks=" + countPunctuation);
    }

    private static int getCountPunctuation(String str) {
        int countPunctuation = 0;
        Pattern patternPunctuation = Pattern.compile("\\p{Punct}+");
        Matcher matcherPunctuation = patternPunctuation.matcher(str);
        while (matcherPunctuation.find()) {
            countPunctuation++;
        }
        return countPunctuation;
    }

    private static int getCountWords(String str) {
        int countWords = 0;
        Pattern patternWords = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcherWords = patternWords.matcher(str);
        while (matcherWords.find()) {
            countWords++;
        }
        return countWords;
    }

    private static String replaceFileTxtInString(String dataPathTaskB, String str) throws FileNotFoundException {
        try (BufferedReader buff = new BufferedReader(new FileReader(dataPathTaskB))) {
            int b;
            StringBuilder strBuilder = new StringBuilder(str);
            while ((b = buff.read()) > 0) {
                strBuilder.append((char) b);
            }
            str = strBuilder.toString();
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        return str;
    }

    public static String getFilePath(String filename, Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + filename;
    }

}
