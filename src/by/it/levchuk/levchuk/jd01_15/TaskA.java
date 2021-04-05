package by.it.levchuk.levchuk.jd01_15;

/*crash-noobik
Liauchuk Aliaksandr*/

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
        fillRandom(matrix);
        String filename = FileNameHelper.getFilePath(MATRIX_TXT, TaskA.class);
        saveTxtMatrix(matrix, filename);
        showFileInConsole(filename);
    }

    private static void saveTxtMatrix(int[][] matrix, String filename) {
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

    private static void showFileInConsole(String filename) {
        try {
            Files.lines(Paths.get(filename))
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final Random random = new Random();

    private static void fillRandom(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + random.nextInt(15 - -15 + 1);
            }
        }
    }
}
