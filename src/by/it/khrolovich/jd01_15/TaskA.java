package by.it.khrolovich.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[6][4];
        fillRandom(matrix, -15, 15);
        String fileName = FileNameHelper.getFilePath("matrix.txt", TaskA.class);
        saveToFile(matrix, fileName);
        // Files.lines(Paths.get(fileName))//Stream<String>
        printToConsoleFromFile(fileName);
    }

    private static void printToConsoleFromFile(String fileName) {
        try {
            Files.lines(Paths.get(fileName))
                    .forEach(System.out::println);//readLine() все строки
            //Files.lines(Paths.get(fileName)).forEach(s->System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveToFile(int[][] matrix, String fileName) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println("");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final Random random = new Random();

    private static void fillRandom(int[][] matrix, int min, int max) {

        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max - min + 1);
            }
        }
    }

}
