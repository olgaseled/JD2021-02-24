package by.it.dudko.jd01_04;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        buildOneDimArray("2 6 3 5 1 1 8");
    }

    static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        double firstElemValue = arr[0];
        double lastElemValue = arr[arr.length - 1];
        InOut.printArray(arr, "V", 5);
        mergeSort(arr);
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

    static void mergeSort(double[] arr) {
        if (arr.length > 1) {
            int middle = arr.length / 2;
            double[] part1 = new double[middle];
            double[] part2 = new double[arr.length - part1.length];
            System.arraycopy(arr, 0, part1, 0, part1.length);
            System.arraycopy(arr, part1.length, part2, 0, part2.length);
            // sort both halves recursively
            mergeSort(part1);
            mergeSort(part2);
            merge(part1, part2, arr);
        }
    }

//    private static void mergeSort(double[] arr, int left, int right) {
//
//    }

    private static void merge(double[] part1, double[] part2, double[] result) {

        int cursorPart1 = 0;
        int cursorPart2 = 0;
        int cursorMerged = 0;
        while (cursorPart1 < part1.length && cursorPart2 < part2.length) {
            if (part1[cursorPart1] < part2[cursorPart2]) {
                result[cursorMerged] = part1[cursorPart1];
                cursorPart1++;
            } else {
                result[cursorMerged] = part2[cursorPart2];
                cursorPart2++;
            }
            cursorMerged++;
        }
        // copy remaining elements from both halves
        System.arraycopy(part1, cursorPart1, result, cursorMerged, part1.length - cursorPart1);
        System.arraycopy(part2, cursorPart2, result, cursorMerged, part2.length - cursorPart2);
    }
}
