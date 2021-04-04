package by.it.korotkevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String USER_DIR = "user.dir";
    public static final String SRC_BY_IT_KOROTKEVICH = "/src/by/it/korotkevich/";
    public static final String JD_01_14_POEM_TXT = "jd01_14/Poem.txt";
    public static final String JD_01_14_RESULT_TASK_B_TXT = "jd01_14/resultTaskB.txt";

    /*
            1. считаем слова
            2. считаем знаки препинания
            3. выводим на консоль
            4. записать в файл
             */
    public static void main(String[] args) {
        String src = System.getProperty(USER_DIR) + SRC_BY_IT_KOROTKEVICH;
        String sourceFilePath = src + JD_01_14_POEM_TXT;
        String txtPath = src + JD_01_14_RESULT_TASK_B_TXT;

        int wordCount = countWordsInTxtFile(sourceFilePath);
        int punctuationCount = countPunctuationMarksInTxtFile(sourceFilePath);
        printToTxtFile(wordCount, punctuationCount, txtPath);
        System.out.printf("words=%d, punctuation marks=%d\n", wordCount, punctuationCount);
    }

    private static int countWordsInTxtFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String oneLine = bufferedReader.readLine();
            int wordCount = 0;
            while (oneLine != null) {
                String[] words = oneLine
                        .trim()
                        .replaceAll("[\\s-.,!]+", " ")
                        .split(" ");
                wordCount += words.length;
                oneLine = bufferedReader.readLine();
            }
            return wordCount;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int countPunctuationMarksInTxtFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String oneLine = bufferedReader.readLine();
            int punctuationCount = 0;
            Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ ]+");
            while (oneLine != null) {
                String punctuationMarks = oneLine;
                Matcher matcher = pattern.matcher(punctuationMarks);
                while (matcher.find()) {
                    punctuationCount += 1;
                }
                oneLine = bufferedReader.readLine();
            }
            return punctuationCount;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToTxtFile(int wordCount, int punctuationCount, String txtPath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(txtPath))){
            bufferedWriter.write("words="+wordCount+", punctuation marks="+punctuationCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
