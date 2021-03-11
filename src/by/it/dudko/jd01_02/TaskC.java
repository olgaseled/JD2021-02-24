package by.it.dudko.jd01_02;

import java.lang.reflect.Array;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        int[][] arr1, arr2, arr3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array dimension");
        int arrDim = sc.nextInt(); // Read user input
        step1(arrDim);
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
}
