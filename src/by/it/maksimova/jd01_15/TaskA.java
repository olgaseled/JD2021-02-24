package by.it.maksimova.jd01_15;

import by.it._classwork_.jd01_15.FileNameHelper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskA {
    //    Создайте матрицу 6строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
//Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15.
// При выводе для каждого числа нужно предусмотреть для него три знакоместа, после чисел –один пробел.
//Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    public static final String MATRIX_TXT = "matrix.txt";
    String filename = dir(TaskA.class)+MATRIX_TXT;

    private static String dir(Class<?> cl) {
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        //generate matrix
        do {
            for (int[] row : matrix) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = -15 + (int) (Math.random() * 31);
                }
            }
        } while (matrix.toString().contains("15") && matrix.toString().contains("-15"));

//writeMatrix
try (PrintWriter printWriter = new PrintWriter(dir(TaskA.class)+ MATRIX_TXT)) {
    for (int[] row : matrix) {
        for (int element : row) {
            printWriter.printf("%3d", element);
            System.out.println();
        }
    }
} catch (FileNotFoundException e) {
    throw new RuntimeException(e);
}

        try {
            Files.lines(Paths.get(dir(TaskA.class)+MATRIX_TXT))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
