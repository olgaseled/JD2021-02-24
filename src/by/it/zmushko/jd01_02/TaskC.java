package by.it.zmushko.jd01_02;

import java.util.Random;
import java.util.Scanner;


public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //размер квадратной матрицы
        int[][] array = step1(n);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        step1(n);
        step2(array);
        step3(array);
    }

    /**
     * @param arr - ddasdasdasda
     * @author
     * @{www.tut,by} {1,7,9,4}
     * {5,6,9,2}
     * 1,2,3,4
     * 6 7 8 5
     * 9 0 0 0
     */
    private static int[][] step3(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        boolean[] delRow = new boolean[arr.length];
        boolean[] delCol = new boolean[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }
        int rows = getFalseCount(delRow);
        int cols = getFalseCount(delCol);

        int[][] resultArray = new int[rows][cols];

        for (int i = 0, ir = 0; i < arr.length; i++) {
            if (!delRow[i]) {
                for (int j = 0, jr = 0; j < arr[i].length; j++) {
                    if (!delCol[j]) {
                        resultArray[ir][jr++] = arr[i][j];
                    }
                }
                ir++;
            }
        }

        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray.length; j++) {
                System.out.print(resultArray[i][j]+" ");
            }
            System.out.println();
        }
        return resultArray;
    }

    private static int getFalseCount(boolean[] delRow) {
        int count = 0;
        for (boolean delete : delRow) {
            if (!delete) {
                count++;
            }
        }
        return count;
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        int endSum = 0;
        int start = 0, end = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            do {
                if (start == 1 && arr[i][j] < 0) {
                    sum += arr[i][j];
                }
                if (arr[i][j] >= 0 && end != 2) {
                    start++;
                    end++;
                }
                if (j < arr.length - 1) {
                    j++;
                } else {
                    break;
                }
            } while (end != 2);

            if (end != 2) {
                sum = 0;
            }
            endSum += sum;
            sum = 0;
            j = 0;
            start = 0;
            end = 0;
        }
        System.out.println(endSum + " ");
        return endSum;
    }

    private static int[][] step1(int n) {
        int[][] array = new int[n][n];
        Random rand = new Random();
        boolean min = false;
        boolean max = false;
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = (rand.nextInt(n + n + 1) - n);
                    if (array[i][j] == n) {
                        max = true;
                    }
                    if (array[i][j] == -n) {
                        min = true;
                    }
                }
            }
        } while (max != true || min != true);
        return array;
    }
}
