package by.it.kirichenko.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TaskB {
    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/by/it/kirichenko/";
        String fileName = src + "/jd01_14/Poem.txt";

        File file = new File(fileName);
        int charFromFile = 0;
        int previosCharFromFile = -1;
        int countPunctuationMarks = 0;
        StringBuilder stringFromFile = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            String punctuationMarks = "-,.!:;";
            while ((charFromFile = fileReader.read()) != -1) {
                if (punctuationMarks.indexOf(charFromFile) != -1) {
                    if (charFromFile != previosCharFromFile) {
                        countPunctuationMarks++;
                    }
                    System.out.println(countPunctuationMarks + ":" + (char) charFromFile);
                } else {

                    stringFromFile.append((char) charFromFile);
                }
                previosCharFromFile = charFromFile;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arrayWords = stringFromFile.toString().trim().split("[\\s\\n\\r]+");
        System.out.printf("words=%d, punctuation marks=%d", arrayWords.length, countPunctuationMarks);

        printToTxtFile(arrayWords.length, countPunctuationMarks);
    }

    private static void printToTxtFile(int countWords, int countPunctuationMarks) {
        String src = System.getProperty("user.dir") + "/src/by/it/kirichenko/";
        String fileName = src + "/jd01_14/resultTaskB.txt";

        try (PrintWriter printWriter = new PrintWriter(fileName)) {

            printWriter.printf("words=%d, punctuation marks=%d", countWords, countPunctuationMarks);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("my message", e);
        }
    }

}
