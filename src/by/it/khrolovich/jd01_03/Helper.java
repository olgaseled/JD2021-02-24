package by.it.khrolovich.jd01_03;

public class Helper {

    /**
     * find minimum of array
     *
     * @param arr input Array
     * @return min value of array
     */
    static double findMin(double[] arr) {
        if (arr.length == 0) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double element : arr) {
                if (element < min) {
                    min = element;
                }
            }
            return min;
        }
    }

    /**
     * find maximum of array
     *
     * @param arr input Array
     * @return max value of array
     */
    static double findMax(double[] arr) {
        if (arr.length == 0) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double element : arr) {
                if (element > max) {
                    max = element;
                }
            }
            return max;
        }
    }

    /**
     * sort of array
     *
     * @param arr input Array
     */

    static void sort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            double temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            arr[j] = temp;
        }
    }

    /**
     * @param matrix input matrix
     * @param vector input vector
     * @return result of multiply of matrix and vector
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] resVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                resVector[i] = resVector[i] + matrix[i][j] * vector[j];
            }
        }
        return resVector;
    }

    /**
     * @param matrixLeft  first input matrix
     * @param matrixRight second input matrix
     * @return result of multiply of two matrix
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    resMatrix[i][j] = resMatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return resMatrix;
    }
}
