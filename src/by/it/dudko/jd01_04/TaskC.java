package by.it.dudko.jd01_04;

public class TaskC {
    public static void main(String[] args) {
        buildOneDimArray("2 6 3 5 1 1 8");
    }

    @SuppressWarnings("SameParameterValue")
    static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        double firstElemValue = arr[0];
        double lastElemValue = arr[arr.length - 1];
        InOut.printArray(arr, "V", 5);
        mergeSort(arr);
        InOut.printArray(arr, "V", 4);
        int indexOfFirst = binarySearch(arr, firstElemValue);
        int indexOfLast = binarySearch(arr, lastElemValue);
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

    private static int binarySearch(double[] arr, double needle) {
        // arr is already ordered
        int base;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            base = (right + left) / 2;
            if (arr[base] == needle) {
                return base;
            } else if (arr[base] > needle) {
                right = base - 1;
            } else {
                left = base + 1;
            }
        }

        return -1;
    }
}
