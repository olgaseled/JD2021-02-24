package by.it.zmushko.jd01_15;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class TaskA {

    private static final Random rand = new Random();
    public static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillRandomMatrix(matrix, -15, 15);
        System.out.println(Arrays.deepToString(matrix));
        String filePath = FindPath.getFilePath(MATRIX_TXT, TaskA.class);
        printMatrixInFile(matrix, filePath);
        printFileElementsInConsole(filePath);
    }

    private static void printFileElementsInConsole(String filePath) {
        try  {
            Files.lines(Paths.get(filePath)).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printMatrixInFile(int[][] matrix, String filePath) {
        try (final PrintWriter writer = new PrintWriter(filePath)) {
            for (int[] ints : matrix) {
                for (int i = 0; i < ints.length; i++) {
                    writer.printf("%3d ",ints[i]);
                }
                writer.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fillRandomMatrix(int[][] matrix, int min, int max) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + rand.nextInt(max - min + 1);
            }
        }
        if (!checkOnMinMaxInArray(matrix, min, max)){
            fillRandomMatrix(matrix, min, max);
        }
    }

    private static boolean checkOnMinMaxInArray(int[][] matrix, int min, int max) {
        boolean findMax = false;
        boolean findMin = false;
        for (int[] ints : matrix) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == max) findMax = true;
                if (ints[i] == min) findMin = true;
            }
        }
        if (findMax && findMin) {
            return true;
        }
        return false;
    }

}
