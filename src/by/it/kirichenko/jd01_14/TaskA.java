package by.it.kirichenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TaskA {

    private static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String RESULT_TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        Class<TaskA> currentStructure = TaskA.class;
        String dataTaskAPath = getFilePath(DATA_TASK_A_BIN, currentStructure);
        String txtPath = getFilePath(RESULT_TASK_A_TXT, TaskA.class);


        saveIntegers(dataTaskAPath);
        List<Integer> list = getIntegers(dataTaskAPath);
        printToConsole(list);
        printToTxtFile(list, txtPath);
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

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            sum += integer;
            System.out.printf("%d ", integer);
        }
        System.out.printf(Locale.ENGLISH, "\navg=%f\n", sum / list.size());
    }

    private static List<Integer> getIntegers(String dataTaskAPath) {
        List<Integer> list = new ArrayList<>();
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(dataTaskAPath)));
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

    private static void saveIntegers(String dataTaskAPath) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(dataTaskAPath)
                        )
                )
        ) {
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                int j = random.nextInt(1000);
                dataOutputStream.writeInt(j);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFilePath(String filename, Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName() //by.it._tasks_.jd01_14.TaskA
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + filename;
    }
}
