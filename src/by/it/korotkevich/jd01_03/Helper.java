package by.it.korotkevich.jd01_03;

class Helper {
    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            Double min = arr[0];
            for (double element : arr) {
                if (min > element) {
                    min = element;
                }
            }
            return min;
        }

    }

    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            Double max = arr[0];
            for (double element : arr) {
                if (max < element) {
                    max = element;
                }
            }
            return max;
        }
    }

    static void sort(double[] arr) {
        boolean swap;
        double last = arr.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j + 1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];
            }
        }
        return z;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight) {
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j]=z[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return z;
    }
}
