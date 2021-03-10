package by.it.savchenko.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        step3(arr);
    }

    private static int[][] step3(int[][] arr) {

        /*System.out.println("Matrix:");
        for (int[] values : arr) {
            for (int value : values)
                System.out.printf("%3d", value);
            System.out.println();
        }

        int max = Integer.MIN_VALUE;
        int i_max = 0, j_max = 0;

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length; ++j) {
                if (arr[i][j] > max) {
                    i_max = i;
                    j_max = j;
                    max = arr[i][j];
                }
            }
        }

        System.out.println("\nМаксимальный элемент: " + max + "\ti: " + i_max + "\tj: " + j_max + "\n");

        int[][] _mas = new int[arr.length - 1][arr.length - 1];

        int new_i = 0, new_j = 0;

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length; ++j) {

                if (i != i_max) {
                    if (j != j_max) {
                        _mas[new_i][new_j] = arr[i][j];
                        ++new_j;
                    }
                } else {
                    --new_i;
                    break;
                }
            }

            ++new_i;
            new_j = 0;
        }

        return _mas;
    }
}*/


        int max = 0;
        int row = 0;
        int col = 0;
        int new_row = 0;
        int new_col = 0;

        //int[][] matrix = new int[n][n];
        int[][] matrix_res = new int[arr.length - 1][arr.length - 1];

        // заполнение квадратного массива с длины  n. [п.с. очень лень было вписывать элементы рукой]
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();*/

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();

            // поиск (первого) макисмального элемента
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                        row = i;
                        col = j;
                    }
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (i != row) {

                    for (int j = 0; j < arr.length; j++) {
                        if (j != col) {

                            System.out.print(arr[i][j] + " ");
                            matrix_res[new_row][new_col] = arr[i][j]; //если создание результативного массива обязательно то нужно откомментить
                            new_col++;
                        }

                    }
                    new_col = 0;
                    new_row++;
                    System.out.println();
                }
            }
            return matrix_res;

        }
    }
