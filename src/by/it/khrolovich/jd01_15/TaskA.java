package by.it.khrolovich.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

public class TaskA{
    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[6][4];
        fillRandom(matrix,-15,15);
        String fileName = FileNameHelper.getFilePath("matrix.txt",TaskA.class);

        try(PrintWriter out = new PrintWriter(fileName)){
            for (int[] row : matrix) {
                for (int element : row) {
                    System.out.println(element+" ");//?
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Stream<String> line = Files.lines(Paths.get(fileName));

    }

    private static  final Random random = new Random();

    private static void fillRandom(int[][] matrix, int min, int max) {

        for (int[] row : matrix) {

        }
    }

}
