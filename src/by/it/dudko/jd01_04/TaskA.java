package by.it.dudko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers separated by space");
        String numbersLine = sc.nextLine();
        buildOneDimArray(numbersLine);
    }

    static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        double firstElemValue = arr[0];
        double lastElemValue = arr[arr.length-1];
        InOut.printArray(arr, "V", 5);
        sort(arr);
        InOut.printArray(arr, "V", 4);
        int indexOfFirst = Arrays.binarySearch(arr, firstElemValue);
        int from, to;
        if (firstElemValue <= lastElemValue) {
            from = indexOfFirst;
            to = arr.length;
        } else {
            from = 0;
            to = indexOfFirst;
        }
        int indexOfLast = Arrays.binarySearch(arr, from, to, lastElemValue);
        System.out.printf("Index of first element=%d\nIndex of last element=%d", indexOfFirst, indexOfLast);
    }


    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9 ; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }


    static void sort(double[] arr) {
        int currInsPos, i;
        double movingValue;

        if (0 == arr.length) {
            System.out.println("Given array is empty. No elements to sort.");
        } else {
            for (i = 1; i < arr.length; i++) {
                currInsPos = i;
                movingValue = arr[currInsPos];
                while (currInsPos > 0 && arr[currInsPos - 1] > movingValue) {
                    arr[currInsPos] = arr[currInsPos - 1];
                    currInsPos--;
                }
                if (currInsPos != i) {
                    arr[currInsPos] = movingValue;
                }
            }
        }
    }
}
