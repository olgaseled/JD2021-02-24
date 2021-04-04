package by.it.dudko.jd01_14;

import java.io.*;
import java.util.*;

public class TaskA {

    public static int RANDOM_RANGE = 5;
    public static final String USER_DIR = "user.dir";
    public static final String FILE_SEPARATOR = "file.separator";
    public static final String SRC = "src";
    public static String OUTPUT_FILE_NAME = "dataTaskA.bin";
    public static String RESULT_FILE_NAME = "resultTaskA.txt";

    public static void main(String[] args) {

        String outputFilePath = getFullPathToFile(OUTPUT_FILE_NAME);
        String resultFilePath = getFullPathToFile(RESULT_FILE_NAME);
        File writeFile = new File(outputFilePath);
        File resultFile = new File(resultFilePath);

        List<Integer> outputIntegers = new ArrayList<>();
        fillListWithRandoms(outputIntegers, RANDOM_RANGE);
        writeIntsToDataOutStream(outputIntegers, writeFile);
        List<Integer> inputIntegers = readIntsFromDataInputStream(writeFile);
        String result = getResult(inputIntegers);
        System.out.println(result);
        printResultToTextFile(result, resultFile);
    }

    private static void printResultToTextFile(String result, File outFile) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(outFile);
            fileWriter.write(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (!Objects.isNull(fileWriter)) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    //noinspection ThrowFromFinallyBlock
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static String getResult(List<Integer> inputIntegers) {
        int sum = 0;
        double avgSum;
        StringBuilder stringBuilder = new StringBuilder();
        StringJoiner sj = new StringJoiner(" ");
        for (Integer inpInt : inputIntegers) {
            sum += inpInt;
            sj.add(inpInt.toString());
        }
        avgSum = (double) sum / inputIntegers.size();
        stringBuilder
                .append(sj)
                .append("\n")
                .append("avg=")
                .append(avgSum);

        return stringBuilder.toString();
    }

    private static List<Integer> readIntsFromDataInputStream(File sourceFile) {
        List<Integer> intColl = new ArrayList<>();
        try (DataInputStream inStream = new DataInputStream(new FileInputStream(sourceFile))) {
            while (inStream.available() > 0) {
                intColl.add(inStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return intColl;
    }

    private static void writeIntsToDataOutStream(List<Integer> intList, File outFile) {
        try (
                DataOutputStream outStream = new DataOutputStream(
                        new FileOutputStream(outFile)
                )
        ) {
            for (int intValue : intList) {
                outStream.writeInt(intValue);
            }

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

    private static void fillListWithRandoms(List<Integer> targetList, int range) {
        Random random = new Random();
        for (int i = 0; i < range; i++) {
            targetList.add(random.nextInt(range) + 1);
        }
    }

}
