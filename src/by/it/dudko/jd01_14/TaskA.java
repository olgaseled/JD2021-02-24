package by.it.dudko.jd01_14;

import java.io.*;
import java.util.Random;
import java.util.StringJoiner;

public class TaskA {

    public static int RANDOM_RANGE = 20;
    public static final String USER_DIR = "user.dir";
    public static final String FILE_SEPARATOR = "file.separator";
    public static final String SRC = "src";
    public static String OUTPUT_FILE_NAME = "dataTaskA.bin";

    public static void main(String[] args) {

        String outputFilePath = getFullPathToFile(OUTPUT_FILE_NAME);
        File outFile = new File(outputFilePath);

        try {
            DataOutputStream out = getDataOutputStream(outFile);
            for (int i = 0; i < RANDOM_RANGE; i++) {
                int data = getRandomInt(RANDOM_RANGE);
                out.writeInt(data);
            }
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }


    }

    private static DataOutputStream getDataOutputStream(File outFile) {
        try (
                DataOutputStream outStream = new DataOutputStream(
                    new FileOutputStream(outFile)
                )
        ) {
            return outStream;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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

    private static int getRandomInt(int range) {
        Random random = new Random(123);
        return random.nextInt(range);
    }

}
