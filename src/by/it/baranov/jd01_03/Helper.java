package by.it.baranov.jd01_03;

public class Helper {


    static void findMin(double[] arr) {
        Double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= min) {  //<---fix is here
                min = arr[i];

            }


        }
        System.out.println(min);
    }


    static void findMax(double[] arr) {
        Double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {  //<---fix is here
                max = arr[i];

            }


        }
        System.out.println(max);
    }


    static void sort(double[] arr) {
        Double temp = null;
        for (int i = 0; i < arr.length; i++) {
            Double min = arr[i];
            int minId = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minId = j;
                }
            }
            // replace
            temp = arr[i];
            arr[i] = min;
            arr[minId] = temp;

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }
}











