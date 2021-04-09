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

    public static double[] mergeSort(double[] list) {
        // If list is empty; no need to do anything
        if (list.length <= 1) {
            return list;
        }

        // Create 2 lists to hold 1st half and 2nd half of original list.
        double[] first = new double[list.length / 2];
        double[] second = new double[list.length - first.length];
        // Split the array in half and populate above lists.
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        // Sort each half recursively
        mergeSort(first);
        mergeSort(second);

        // Merge both halves together, overwriting original array
        merge(first, second, list);
        return list;
    }


    private static void merge(double[] first, double[] second, double[] result) {
        // Index Position in first array - starting with first element
        int iFirst = 0;

        // Index Position in second array - starting with first element
        int iSecond = 0;

        // Index Position in merged array - starting with first position
        int iMerged = 0;

        // Compare elements at iFirst and iSecond,
        // and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        // copy remaining elements from both halves - each half will have already sorted
        // elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
}
