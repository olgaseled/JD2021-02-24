package by.it.dudko.jd01_03;

import java.util.Arrays;

public class InOut {
    /**
     * Parses input string as an array of double numbers
     * @param numbersLine String of numbers separated by space character
     * @return an array of double numbers
     */
    static double[] getArray(String numbersLine) {
        String[] rawArr = numbersLine.trim().split(" ");
        double[] outputArr = new double[rawArr.length];
        for (int i = 0; i < rawArr.length; i++) {
            outputArr[i] = Double.parseDouble(rawArr[i]);
        }
        return outputArr;
    }

    /**
     * Prints to the console string representation of the given array
     * @param arr an array to print
     */
    static void printArray(double[] arr) {
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }

    /**
     * Prints to the console in formatted way all the array elements' indices and values as well it's name
     * @param arr an array to print
     * @param name a name (an alias) of the given array to use in the console output
     * @param columnCount maximum number of array elements to print in a single row
     */
    static void printArray(double[] arr, String name, int columnCount) {
        if (columnCount != 0) {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%s[% 03d ]=%-8.1f", name, i, arr[i]);
                if (0 == (i + 1) % columnCount
                        || arr.length - 1 == i) {
                    System.out.println();
                }
            }
        }
    }
}
