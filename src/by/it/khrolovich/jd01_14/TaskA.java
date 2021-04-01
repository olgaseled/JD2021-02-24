package by.it.khrolovich.jd01_14;

import java.io.*;
import java.util.*;

public class TaskA {
    private static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        Class<TaskA> currentStructure = TaskA.class;
        String filePath = getFilePath(DATA_TASK_A_BIN, currentStructure);
        String txtPath = getFilePath(RESULT_TASK_A_TXT, currentStructure);

        saveIntegers(filePath);
        List<Integer> list = getIntegers(filePath);
        printToConsole(list);
        printToFile(list, txtPath);

    }

    private static void printToFile(List<Integer> list, String txtPath) {

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

    private static List<Integer> getIntegers(String filePath) {
        List<Integer> list = new ArrayList<>();
        DataInputStream dataInputStream = null;//
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
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
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

    private static void saveIntegers(String filePath) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(filePath)
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

    private static String getFilePath(String fileName, Class<?> currentStructure) {
        //private static String getFilePath(String fileName, Class<TaskA> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);//здесь в IDE это корень проекта
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + fileName;
    }
}
