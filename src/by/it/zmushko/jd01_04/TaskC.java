package by.it.zmushko.jd01_04;

import by.it.zmushko.jd01_03.InOut;

public class TaskC {

    public static void main(String[] args) {
        buildOneDimArray("2 3 4 5 6 1 2 3 4 6 7 12 43 2 5 6 2");
    }

    public static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array, 0, array.length - 1);
        InOut.printArray(array, "V", 5);
       // int indexFirst = Arrays.binarySearch(array, first);
        System.out.printf("first element=%1d", binarySearch(array, first));
        System.out.println();
        // int indexLast = Arrays.binarySearch(array, last);
        System.out.printf("last element=%1d", binarySearch(array, last));
        System.out.println();
    }

    public static void mergeSort(double[] array) {

        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(double[] array, int left, int right) {

        if (array.length == 0) {
            return;
        }
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int mid = (left + right) / 2;
        double oporniyElement = array[mid];
        while (i <= j) {
            while (array[i] < oporniyElement) {
                i++;
            }
            while (array[j] > oporniyElement) {
                j--;
            }
            if (i <= j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
            if (left < j) {
                mergeSort(array, left, j);
            }
            if (right > i) {
                mergeSort(array, i, right);
            }
        }
    }

    static int binarySearch(double[] array, double value) {
        int index = 0;
        int min = 0;
        int max = array.length - 1;
        while (min <= max) {
            int mid =  (min + max) / 2;
            if (array[mid] < value) {
                min = mid + 1;
            } else if (array[mid] > value) {
                max = mid - 1;
            } else if (array[mid] == value) {
                index = mid;
                break;
            }
        }
        return index;
    }

}
