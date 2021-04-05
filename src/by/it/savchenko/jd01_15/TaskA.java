package by.it.savchenko.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TaskA {

    private static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillRandom(matrix, -15, 15);
        String filename = FileNameHelper.getFilePath(MATRIX_TXT, TaskA.class);
        saveTxtxMatrix(matrix, filename);
        showFileInConsole(filename);
    }

    private static void showFileInConsole(String filename) {
        try {
            Files.lines(Paths.get(filename))
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveTxtxMatrix(int[][] matrix, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final Random random = new Random();

    @SuppressWarnings("SameParameterValue")
    private static void fillRandom(int[][] matrix, int min, int max) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max - min + 1);
            }
        }
    }

}
