package by.it.dudko.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers separated by space");
        String numbersLine = sc.nextLine();
        double[] arr = InOut.getArray(numbersLine);

        System.out.println("Enter array name");
        String arrName = sc.nextLine();
        System.out.println("Enter column count for print");
        int columnCount = sc.nextInt();

        InOut.printArray(arr);
        InOut.printArray(arr, arrName, columnCount);

        double minElem = Helper.findMin(arr);
        double maxElem = Helper.findMax(arr);
        System.out.printf("The lowest array value: %-4.1f\nthe highest array value: %.1f", minElem, maxElem);
        System.out.println();

        Helper.sort(arr);
        System.out.println("Sorted array:");
        InOut.printArray(arr, arrName, columnCount);

        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-6, -5, -4}
        };

        double[][] matrixRight = {
                {3, 6, 7, 8},
                {8, 10, 2, 1},
                {4, 5, 6, 0}
        };
        double[] vector = {-5 , 10};
        double[] resultVector;
        double[][] resultMatrix;


        resultVector = Helper.mul(matrix, vector);
        resultMatrix = Helper.mul(matrix, matrixRight);

        System.out.println("Matrix * Vector:");
        InOut.printArray(resultVector, "v", resultVector.length);
        System.out.println();
        System.out.println("Matrix * Matrix:");
        for (double[] m : resultMatrix) {
            InOut.printArray(m, "m", m.length);
        }

    }

}
