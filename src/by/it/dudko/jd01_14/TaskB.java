package by.it.dudko.jd01_14;

import java.io.*;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String USER_DIR = "user.dir";
    public static final String FILE_SEPARATOR = "file.separator";
    public static final String SRC = "src";
    public static String SRC_FILE_NAME = "Poem.txt";
    public static String RESULT_FILE_NAME = "resultTaskB.txt";

    public static void main(String[] args) {
        int punctuationMarksCount, wordsCount;
        String srcFilePath = getFullPathToFile(SRC_FILE_NAME);
        String srcOutputPath = getFullPathToFile(RESULT_FILE_NAME);

        String txtData = readTxtFileContent(srcFilePath);
        Pattern punctuationMarks = Pattern.compile("[-,;:!]|\\.+");
        Pattern words = Pattern.compile("[а-яА-ЯЁё]+");
        punctuationMarksCount = countMatchesByGivenPattern(punctuationMarks, txtData);
        wordsCount = countMatchesByGivenPattern(words, txtData);
        String output = createResultLine(punctuationMarksCount, wordsCount);
        printResultToConsole(output);
        printResultToTextFile(output, srcOutputPath);

    }

    private static void printResultToTextFile(String output, String outputFilePath) {
        try (PrintWriter printWriter = new PrintWriter(outputFilePath)) {
            printWriter.print(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("my message", e);
        }
    }

    private static void printResultToConsole(String output) {
        System.out.println(output);
    }

    private static String createResultLine(int punctuationMarksCount, int wordsCount) {
        return String.format(
                "words=%d, punctuation marks=%d", wordsCount, punctuationMarksCount
        );
    }

    private static int countMatchesByGivenPattern(Pattern pat, String text) {
        int counter = 0;
        Matcher matcher = pat.matcher(text);
        while(matcher.find()) {
            counter++;
        }
        return counter;
    }

    private static String readTxtFileContent(String srcFilePath) {
        int i;
        char c;
        StringBuilder sb = new StringBuilder();

        try (
                InputStreamReader reader = new InputStreamReader(
                        new FileInputStream(srcFilePath)
                )
        ) {
            while ((i = reader.read()) != -1) {
                sb.append((char) i);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    private static String getFullPathToFile(String fileName) {
        String projectRoot = System.getProperty(USER_DIR);
        String fileSeparator = System.getProperty(FILE_SEPARATOR);
        Class<TaskA> classStructure = TaskA.class;
        String classSimpleName = classStructure.getSimpleName();
        String classRelPath = classStructure.getName()
                .replace(classSimpleName, "")
                .replace(".", fileSeparator);
        StringJoiner classFullPath = new StringJoiner(fileSeparator);
        return classFullPath
                .add(projectRoot)
                .add(SRC)
                .add(classRelPath)
                .add(fileName).toString();
    }
}
