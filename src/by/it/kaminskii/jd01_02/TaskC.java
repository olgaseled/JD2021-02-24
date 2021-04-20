package by.it.kaminskii.jd01_02;


import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] step1 = step1(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(step1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("step2: " + step2(step1));
        System.out.println();
        int[][] step3 = step3(step1);
        for (int i = 0; i < step3.length; i++) {
            for (int j = 0; j < step3[0].length; j++) {
                System.out.print(step3[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] step1(int n) {
        int[][] step1 = new int[n][n];
        while (true) {
            boolean plus = false;
            boolean minus = false;

            for (int i = 0; i < step1.length; i++) {
                for (int j = 0; j < step1[0].length; j++) {

                    step1[i][j] = getRandomNumber(-n, n);

                    if (step1[i][j] == n) {
                        plus = true;
                    }

                    if (step1[i][j] == (-n)) {
                        minus = true;
                    }
                }
            }

            if (plus && minus) {
                break;
            }
        }
        return step1;
    }

    static int step2(int[][] arr) {

        int result = 0;

        for (int[] row : arr) {
            int rowSum = 0;
            boolean firstWasFound = false;
            for (int j = 0; j < arr[0].length; j++) {
                int v1 = row[j];
                int v2;

                if (j < arr[0].length - 1) {
                    v2 = row[j + 1];
                } else {
                    rowSum = 0;
                    break;
                }

                if (!firstWasFound && v1 <= 0) {
                    continue;
                } else {
                    firstWasFound = true;
                }

                if (v2 > 0) {
                    break;
                }

                rowSum += v2;
            }
            result += rowSum;
        }

        return result;
    }


    static int[][] step3(int[][] arr) {
        boolean[] rows = new boolean[arr.length];
        boolean[] columns = new boolean[arr.length];

        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == max) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        int rowCount = 0;
        for (boolean row : rows) {
            if (!row) {
                rowCount++;
            }
        }

        int columnCount = 0;
        for (boolean column : columns) {
            if (!column) {
                columnCount++;
            }
        }

        int[][] result = new int[rowCount][columnCount];

        for (int i = 0, ri = 0; i < arr.length; i++) {
            if (rows[i]) {
                continue;
            }
            for (int j = 0, rj = 0; j < arr.length; j++) {
                if (columns[j]) {
                    continue;
                }
                result[ri][rj] = arr[i][j];
                rj++;
            }
            ri++;
        }

        return result;
    }


    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max + 1) - min) + min;
    }

}





