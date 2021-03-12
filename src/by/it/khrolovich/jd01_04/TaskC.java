package by.it.khrolovich.jd01_04;

import by.it.khrolovich.jd01_03.InOut;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {

    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);

        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.printf("first element=%d", i);
                break;
            }
        }
        System.out.println();
        int indexLast = Arrays.binarySearch(array, last);
        System.out.printf("last element=%d", indexLast);
    }

    static void mergeSort(double[] array) {

    }

    private static void mergeSort(double[] array, int left, int right) {
        int m = (left + right) / 2;
        double x = (int) array[left];
    }

    private static double[] merge(double[] part1, double[] part2) {
        return part1;
    }
}
