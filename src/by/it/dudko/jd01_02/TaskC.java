package by.it.dudko.jd01_02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array dimension");
        int arrDim = sc.nextInt(); // Read user input
        int[][] matrix = step1(arrDim);
        int targetSum = step2(matrix);
        int[][] resultMatrix = step3(matrix);
    }

    public static int[][] step3(int[][] matrix) {
        int max = findMax(matrix);
        int[] rowFlags = new int[matrix.length];
        int[] colFlags = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (max == matrix[i][j]) {
                    rowFlags[i] = 1;
                    colFlags[j] = 1;
                }
            }
        }
        int delRows = getArrSum(rowFlags);
        int delCols = getArrSum(colFlags);
        int[][] shortMatrix = new int[matrix.length - delRows][matrix.length - delCols];
        for (int i = 0, m = 0; i < matrix.length; i++) {
            if (rowFlags[i] == 1) {
                continue;
            }
            for (int j = 0, n = 0; j < matrix[i].length; j++) {
                if (colFlags[j] == 1) {
                    continue;
                }
                shortMatrix[m][n++] = matrix[i][j];
            }
            m++;
        }
        print2DArray(shortMatrix);
        return shortMatrix;
    }

    static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        boolean minEdgeFound = false;
        boolean maxEdgeFound = false;
        while (!minEdgeFound || !maxEdgeFound) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int nextInt = getRandomNumberFromRange(-n, n);
                    arr[i][j] = nextInt;
                    if (!minEdgeFound && nextInt == -n) {
                        minEdgeFound = true;
                    }
                    if (!maxEdgeFound && nextInt == n) {
                        maxEdgeFound = true;
                    }
                }
            }
        }
        print2DArray(arr);
        return arr;
    }

    static int step2(int[][] matrix) {
        int acc = 0;
        for (int[] row : matrix) {
            boolean sumMode = false;
            for (int rowItem : row) {
                if (rowItem < 0) {
                    if (sumMode) {
                        acc += rowItem;
                    }
                } else {
                    if (!sumMode) {
                        sumMode = true;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(acc);
        return acc;
    }

    static int getRandomNumberFromRange(int min, int max) {
        int rangeMax = max - min; //
        return (int) (Math.random() * (rangeMax + 1)) + min;
    }

    static void print2DArray(int[][] arr) {
        String row = "";
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                row += ints[j];
                if (j + 1 < arr.length) {
                    row += " ";
                }
            }
            System.out.println(row); // write out finished row
            row = ""; // begin new empty row
        }
    }

    static int findMax(int[][] matrix) {
        int maxValue = matrix[0][0];
        for (int[] row : matrix) {
            for (int rowItem : row) {
                if (maxValue < rowItem) {
                    maxValue = rowItem;
                }
            }
        }
        return maxValue;
    }

    static int getArrSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
