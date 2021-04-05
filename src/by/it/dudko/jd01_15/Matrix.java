package by.it.dudko.jd01_15;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private final int[][] value;
    private final int width;
    private final int height;
    private final Random random = new Random();
    private int currentRow;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        this.value = new int[height][width];
    }

    public int[][] getInstance() {
        int[][] instance = new int[height][width];
        for (int i = 0; i < height; i++) {
            instance[i] = Arrays.copyOf(value[i], value[i].length);
        }
        return instance;
    }

    public int[] nextRow() {
        if (currentRow == height) {
            currentRow = 0;
            return null;
        }
        int[] row = Arrays.copyOf(value[currentRow], value[currentRow].length);
        currentRow++;
        return row;

    }

    public void fillWithRandoms(int inclFrom, int inclTo) {
        boolean minStatus = false,
                maxStatus = false;
        while (!minStatus || !maxStatus) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    value[i][j] = inclFrom + random.nextInt(inclTo - inclFrom + 1);
                    if (!minStatus && value[i][j] == inclFrom) minStatus = true;
                    if (!maxStatus && value[i][j] == inclTo) maxStatus = true;
                }
            }
        }
    }
}
