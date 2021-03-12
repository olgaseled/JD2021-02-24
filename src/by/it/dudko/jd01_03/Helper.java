package by.it.dudko.jd01_03;

public class Helper {
    /**
     * Searches and returns the highest value of the provided array
     *
     * @param arr input array to search it's highest value
     * @return highest value of the provided array \
     * or Double.MAX_VALUE constant in case input array has no elements
     */
    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double item : arr) {
                if (max < item) {
                    max = item;
                }
            }
            return max;
        }
    }

    /**
     * Searches and returns the lowest value of the provided array
     *
     * @param arr input array to search it's lowest value
     * @return lowest value of the provided array \
     * or Double.MIN_VALUE constant in case input array has no elements
     */
    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double item : arr) {
                if (min > item) {
                    min = item;
                }
            }
            return min;
        }
    }

    /**
     * Implements Insertion Sort on the given array
     *
     * @param arr an array of double numbers to sort
     */
    static void sort(double[] arr) {
        int currInsPos, i;
        double movingValue;

        if (0 == arr.length) {
            System.out.println("Given array is empty. No elements to sort.");
        } else {
            for (i = 1; i < arr.length; i++) {
                currInsPos = i;
                movingValue = arr[currInsPos];
                while (currInsPos > 0 && arr[currInsPos - 1] > movingValue) {
                    arr[currInsPos] = arr[currInsPos - 1];
                    currInsPos--;
                }
                if (currInsPos != i) {
                    arr[currInsPos] = movingValue;
                }
            }
        }
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

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        if (matrixLeft[0].length != matrixRight.length) {
            System.out.println("Matrices have to be coherent");
            return new double[][]{{}, {}};
        }
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return z;
    }

}
