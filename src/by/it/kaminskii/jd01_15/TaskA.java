package by.it.kaminskii.jd01_15;/* created by Kaminskii Ivan
 */

import by.it._classwork_.jd01_15.FileNameHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TaskA {
    private static final Random random = new Random();
    private static final String MATRIX_TXT = "matrix.txt";

    private static void showFileInConsole(String filename) {
        try {
            Files.lines(Paths.get(filename))
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String dirPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
    private static void saveTxtMatrix(int[][] matrix, String filename) {
        try (PrintWriter out = new PrintWriter(filename + "matrix.txt")) {
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
    private static void fillRandomValueToMatrix(int[][] matrix, int min, int max) {
        boolean checkMin = false;
        boolean checkMax = false;
        while (!checkMax || !checkMin) {
            for (int[] row : matrix) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = min + random.nextInt(max - min + 1);
                    if (row[i] == -15) checkMin = true;
                    else if (row[i] == 15) checkMax = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillRandomValueToMatrix(matrix, -15, 15);
        String filename = FileNameHelper.getFilePath(MATRIX_TXT, by.it._classwork_.jd01_15.TaskA.class);
        saveTxtMatrix(matrix, dirPath(TaskA.class));
        showFileInConsole(dirPath(TaskA.class) + "matrix.txt");
    }

}