package by.it.korotkevich.jd01_15;

import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillRandom(matrix, -15, 15);
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
