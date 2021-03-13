package by.it.kaminskii.jd01_03;

import java.util.Scanner;

public class Helper {
    static double findMin(double[] array) {

        double findMin = array[0];
        for (double min : array) {

            if (findMin > min) {
                findMin = min;
                System.out.println(findMin);
            }

        }
        return findMin;

    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double findMax : arr) {
            if (max < findMax) {
                max = findMax;
            }
        }
        return max;
    }

    static void sort(double[] arr) {

        for (int j = 0; j < arr.length; j++) {
            int minIndex = j;
            for (int i = j; i < arr.length; i++) {
                if (arr[minIndex] > arr[i]) {
                    minIndex = i;
                }

            }
            double sort = arr[j];
            arr[j] = arr[minIndex];
            arr[minIndex] = sort;
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] matrixSize = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                matrixSize[i] += matrix[i][j] * vector[j];
            }
        }
        return matrixSize;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double mul[][] = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mul[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return mul;
    }
}


