package by.it.seledtsova.jd01_15;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
    Класс TaskA
Создайте матрицу 6строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
Выведите матрицу в текстовый файл matrix.txt, расположенный в папке заданияjd01_15. При выводе для каждого
числа нужно предусмотреть для него три знакоместа, после чисел –один пробел.
Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.
     */
public class TaskA {


    public static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillRandomMatrix(matrix);

    }

    // generate
    private static void fillRandomMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (-15 + Math.random() * 31); // от -15 до +15
            }
        }
        for (int i = 0; i < matrix.length; i++, System.out.println()) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        matrix[0][0] = -15;
        matrix[1][1] = 15;
        String fileName = getPath(TaskA.class) + MATRIX_TXT; // ctrl-alt-C - переменную в костанту
        // writeArray
        try (PrintWriter out = new PrintWriter(fileName)
        ) {
            for (int[] row : matrix) {
                //   for (int element: row) // аналогично след строке
                Arrays.stream(row).forEach(element -> out.printf("%3d ", element));
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //showMatrix
        try {
            Files.lines(Paths.get(fileName)).forEach(s -> System.out.println(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("SaveParametrValue")
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator; // определяю ПУТЬ , где находится каталог SRC
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        //узнаю полный путь к классу. TaskA сотрется, а "." заменится "\"
        return path + clDir; // возвращаем путь и инфу из клааса
    }

}





