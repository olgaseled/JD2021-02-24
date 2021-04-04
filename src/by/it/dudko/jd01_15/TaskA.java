package by.it.dudko.jd01_15;

import java.io.*;
import java.util.Objects;

public class TaskA {

    private static final String outTxtName = "matrix.txt";
    private static File outTxtFile = null;

    public static void main(String[] args) {
        Matrix matrix = new Matrix(4, 6);
        matrix.fillWithRandoms(-15, 15);
        printMatrixToFile(matrix);
        readMatrixFromFile();
    }

    private static void readMatrixFromFile() {
        if (Objects.isNull(outTxtFile)) return;
        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(
                        new FileInputStream(outTxtFile)
                );
                BufferedOutputStream bufOutStream = new BufferedOutputStream(System.out)
        ) {
            while (bufferedInputStream.available() > 0) {
                bufferedInputStream.transferTo(bufOutStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printMatrixToFile(Matrix matrix) {
        outTxtFile = new File(FileNameHelper.getFullPath(outTxtName, TaskA.class));
        try (
                PrintWriter printWriter = new PrintWriter(
                        new FileWriter(outTxtFile)
                )
        ) {
            int[] row;
            while ((row = matrix.nextRow()) != null) {
                for (int number : row) {
                    printWriter.printf("%3d ", number);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            throw new RuntimeException("Writing failed", e);
        }
    }
}
