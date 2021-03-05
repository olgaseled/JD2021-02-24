package by.it.maksimova.jd01_04;


import static by.it.maksimova.jd01_04.InOut.printArray;

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }


        }
        return min;
    }


    static double findMax(double[] arr) {

        double max = arr[0];
        for (double v : arr) {
            if (max < v) {
                max = v;
            }


        }
        return max;
    }

    static void sort(double[] arr) {
        boolean swap;
        do {
            swap = false;
            double last = arr.length - 1;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        printArray(arr);

    }

    static double[] mul(double[][] matrix, double[] vector) {

        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];


            }

        }
        return z;
    }

    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] matrixNew = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    matrixNew[i][j] = matrixNew[i][j] + matrixLeft[i][k] + matrixRight[k][j];
                }

            }
        }
        return matrixNew;
    }
}






