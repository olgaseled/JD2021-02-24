package by.it.papruga.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TaskA {


    public static final String MATRIX_TXT = "matrix.txt";


    public static void main(String[] args) throws FileNotFoundException {
        String fn = dir(TaskA.class) + MATRIX_TXT;
        int[][] matrix = generate();
        writeArray(fn, matrix);
        showArray(fn);
    }

    private static void showArray(String fn) {
        try {
            Files.lines(Paths.get(fn))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeArray(String fn, int[][] matrix) {
        try (PrintWriter out = new PrintWriter(fn)
        ) {
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

    private static int[][] generate() {
        int[][] matrix = new int[6][4];
        Random random = new Random();
        for (int[] row : matrix) {

            for (int i = 0; i < row.length; i++) {

                row[i] = -15 + random.nextInt(15 - -15 + 1);
            }
        }
        return matrix;
    }

    @SuppressWarnings("SameParameterValue")
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path + clDir;
    }

}






