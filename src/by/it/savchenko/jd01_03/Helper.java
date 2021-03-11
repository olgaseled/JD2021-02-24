package by.it.savchenko.jd01_03;

import java.util.Arrays;

public class Helper {


    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void sort(double[] arr) {
        Arrays.sort(arr);


    }

    public static double[] mul(double[][] matrix, double[] vector) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[] result = new double[rows];

        for (int row = 0; row < rows; row++) {
            double sum = 0;
            for (int column = 0; column < columns; column++) {
                sum = sum + matrix[row][column] * vector[column];
            }
            result[row] = sum;
        }
        return result;
    }


}




















