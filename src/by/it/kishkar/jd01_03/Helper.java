package by.it.kishkar.jd01_03;

public class Helper {
    static double findMin(double[ ] arr) {
        double resH=arr[0];
        for (double min : arr) {
            if (resH>min) {
                resH=min;
                System.out.println(resH);

            }

        }
        return resH;
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
    }
