package by.it.savchenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class TaskB {
    private static final String DATA_TASK_B_BIN = "dataTaskB.bin";
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String RESULT_TASK_B_TXT = "resultTaskB.txt";
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\yamax\\ideaProjects\\JD2021-02-24-v1\\src\\by\\it\\savchenko\\jd01_14\\Poem.txt");
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);

        String line;
        int word = -2;
        int marks = -3;
        Class<TaskB> currentStructure = TaskB.class;
        String dataTaskBPath = getFilePath(DATA_TASK_B_BIN, currentStructure);
        String txtPath = getFilePath(RESULT_TASK_B_TXT, TaskB.class);
        List<Integer> list = getIntegers(dataTaskBPath);
        printToConsole(list);
        printToTxtFile(list, txtPath);

        while ((line = reader.readLine()) != null) {
            String[] wordList = line.split("\\s+");
            word += wordList.length;
            String[] sentenceList = line.split("[!?.:]+");
            marks += sentenceList.length;
        }

        System.out.println("words=" + word);
        System.out.println("marks=" + marks);
        try {
            file = new File("C:\\Users\\yamax\\ideaProjects\\JD2021-02-24-v1\\src\\by\\it\\savchenko\\jd01_14\\resultTaskB.txt");

            if (!file.exists())
                file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(word);
            bw.write(marks);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printToTxtFile(List<Integer> list, String txtPath) {
        try (PrintWriter printWriter = new PrintWriter(txtPath)) {
            double sumForFile = 0;
            for (Integer integer : list) {
                sumForFile += integer;
                printWriter.printf("%d ", integer);
            }
            printWriter.printf(Locale.ENGLISH, "\navg=%f\n", sumForFile / list.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("my message", e);
        }
    }
    private static String getFilePath(String filename, Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName() //by.it._tasks_.jd01_14.TaskB
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + filename;
    }

    private static List<Integer> getIntegers(String dataTaskBPath) {
        List<Integer> list = new ArrayList<>();
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(dataTaskBPath)));
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    //noinspection ThrowFromFinallyBlock
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }
    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            sum += integer;
            System.out.printf("%d ", integer);
        }
        System.out.printf(Locale.ENGLISH, "\navg=%f\n", sum / list.size());
    }
}



