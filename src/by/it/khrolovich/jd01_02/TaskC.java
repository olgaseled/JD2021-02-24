package by.it.khrolovich.jd01_02;

import by.it.khrolovich.jd01_03.InOut;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arrA = step1(n);
        int sum = step2(arrA);

        int[][] a1 = {
                {1, -2, -2, 6},
                {-1, 2, -2, 2},
                {-2, -2, -6, -2},
                {1, 2, -2, 6}
        };

        int[][] resultArray = step3(a1);
    }

    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        boolean isN = false;
        boolean isMinusN = false;
        while (!(isN && isMinusN)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int delta = 2 * n;
                    arr[i][j] = (int) (Math.random() * ++delta) - n;
                    if (arr[i][j] == n) {
                        isN = true;
                    }
                    if (arr[i][j] == -n) {
                        isMinusN = true;
                    }
                    if (isN && isMinusN) {
                        for (int k = 0; k < n; k++) {
                            for (int l = 0; l < n; l++) {
                                System.out.print(arr[k][l] + " ");
                            }
                            System.out.print('\n');
                        }
                        return arr;
                    }
                }
            }
        }
        return arr;
    }

    private static int step2(int[][] arrA) {
        int sum = 0;
        int n = arrA.length;
        for (int i = 0; i < n; i++) {
            boolean start = false;
            for (int j = 0; j < n; j++) {
                if (arrA[i][j] > 0) {
                    if (!start) {
                        start = true;
                    } else {
                        start = false;
                        break;
                    }
                } else {
                    if (start) {
                        sum = sum + arrA[i][j];
                    }
                }
            }
        }
        System.out.println(sum);
        return sum;
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
                    if (!delCol[j])
                        resultArray[ir][jr++] = array[i][j];
                }
                ir++;
            }
        }
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println(" ");
        }
        return resultArray;
    }

    private static int[][] step4(int n) {
        int[][] array = new int[n][n];
        boolean min;
        boolean max;

        do {
            min = false;
            max = false;
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
