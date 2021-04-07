package by.it.maksimova.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {
    //    Создайте матрицу 6строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
//Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15.
// При выводе для каждого числа нужно предусмотреть для него три знакоместа, после чисел –один пробел.
//Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    public static final String MATRIX_TXT = "matrix.txt";


    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        generateMatrix(matrix);
        String filename = getPath(TaskA.class) + MATRIX_TXT;
        writeMatrix(matrix, filename);
        showMatrix(filename);
    }

    private static String getPath(Class<?> cl) {
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    private static void generateMatrix(int[][] matrix) {
        do {
            for (int[] row : matrix) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = -15 + (int) (Math.random() * 31);
                }
            }
        } while (matrix.toString().contains("15") && matrix.toString().contains("-15"));
    }

    private static void writeMatrix(int[][] matrix, String filename) {
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showMatrix(String filename) {
        try {
            Files.lines(Paths.get(filename))
                    .forEach(x -> System.out.println(x));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
