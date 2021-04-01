package by.it.zmushko.jd01_14;

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
        String dataPathTaskA = getFilePath(DATA_TASK_A_BIN, TaskA.class);
        String txtPath = getFilePath(RESULT_TASK_A_TXT, TaskA.class);
        inputInt(dataPathTaskA);
        List<Integer> finalList = saveInList(dataPathTaskA);
        printConsole(finalList);
        writeInFile(txtPath, finalList);
    }

    private static void writeInFile(String txtPath, List<Integer> finalList) {
        try (PrintWriter printWriter = new PrintWriter(txtPath)) {
            double sum = 0;
            for (Integer integer : finalList) {
                sum+=integer;
                printWriter.printf("%d ", integer);
            }
            printWriter.printf(Locale.ENGLISH,"\navg=%f\n", sum/ finalList.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printConsole(List<Integer> finalList) {
        double sum = 0;
        for (Integer integer : finalList) {
            sum += integer;
            System.out.printf("%d ", integer);
        }
        System.out.printf(Locale.ENGLISH,"\navg=%f\n", sum/ finalList.size());
    }

    private static List<Integer> saveInList(String dataPathTaskA) {
        ArrayList<Integer> listNumberInFile = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dataPathTaskA)
                )
        )
        ) {
            while (dataInputStream.available() > 0) {
                listNumberInFile.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listNumberInFile;
    }

    private static void inputInt(String dataPathTaskA) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dataPathTaskA)
                )
        )
        ) {
            Random rand = new Random();
            for (int i = 0; i < 20; i++) {
                int number = rand.nextInt(100);
                dataOutputStream.writeInt(number);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
