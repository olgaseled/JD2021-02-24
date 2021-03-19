package by.it.seledtsova.jd01_04._classwork_.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] a = step1(n);
        System.out.println(Arrays.deepToString(a));

        int[][] resultArray = step3(a);
        System.out.println(Arrays.deepToString(resultArray));
    }

    private static int[][] step1(int n) {
        int[][] array = new int[n][n];
        boolean min;
        boolean max;
        do {
            max = false;
            min = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (array[i][j] == n) {
                        max = true;
                    }
                    if (array[i][j] == -n) {
                        min = true;
                    }
                }
            }
        } while (!max || !min);
        return array;
    }

    private static int[][] step3(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }

        boolean[] delRow = new boolean[array.length];
        boolean[] delCol = new boolean[array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }

        int rows = getCountFalse(delRow);
        int cols = getCountFalse(delCol);

        int[][] resultArray = new int[rows][cols];

        for (int i = 0, ir = 0; i < array.length; i++) {
            if (!delRow[i]) {
                for (int j = 0, jr = 0; j < array[i].length; j++) {
                    if (!delCol[j]) {
                        resultArray[ir][jr++] = array[i][j];
                    }
                }
                ir++;
            }

        }


        return resultArray;
    }

    private static int getCountFalse(boolean[] delRow) {
        int count = 0;
        for (boolean delete : delRow) {
            if (!delete) {
                count++;
            }
        }
        return count;
    }


}
