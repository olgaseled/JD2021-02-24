package by.it.kaminskii.jd01_02;

import by.it._classwork_.jd01_08.Matrix;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];

        step1(arr.length);

    }

    static int[][] step1(int n) {

        int[][] step1 = new int[n][n];
        boolean plus = false;
        boolean min = false;
        for (int i = 0; i < step1.length; i++) {
            for (int j = 0; j < step1[0].length; j++) {
                while (plus && min) {
                    step1[i][j] = (int) (Math.random() * (5+5)) - 5;
                    System.out.println(step1[i][j]);
                    if (step1[i][j] == n) plus = true;
                    if (step1[i][j] == (-n)) min = true;
                }
            }
        }
        return step1;
    }
}







