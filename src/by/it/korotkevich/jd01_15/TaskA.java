package by.it.korotkevich.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TaskA {

    public static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillRandom(matrix, -15, 15);
        String fileName = Helper.getFilePath(MATRIX_TXT, TaskA.class);
        saveTxtMatrix(matrix, fileName);
        showFileInConsole(fileName);
    }

    private static void saveTxtMatrix(int[][] matrix, String fileName) {
        try (PrintWriter out = new PrintWriter(fileName)){
            for (int[] row : matrix) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showFileInConsole(String fileName) {
        try {
            Files.lines(Paths.get(fileName)).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Random random = new Random();

    private static void fillRandom(int[][] matrix, int min, int max) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i]=min+random.nextInt(max-min+1);
            }
        }
    }
}
