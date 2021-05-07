package by.it.seledtsova2.jd01_03;

public class Helper {
    public static double findMax(double[] array) {
        if (0 == array.length) {
            return Double.MAX_VALUE;
        } else {
            double max = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }
    }


    public static double findMin(double[] array) {
        if (0 == array.length) {
            return Double.MIN_VALUE;
        } else {
            double min = array[0];
            for (double element : array) {
                if (element < min) {
                    min = element;
                }
            }
            return min;
        }
    }


     static void sort(double[] arraySort) {
        boolean swap;
        double lastElement = arraySort.length - 1;
        do {
            swap = false;
            for (int i = 0; i < lastElement; i++) {
                if (arraySort[i] > arraySort[i + 1]) {
                    double buffer = arraySort[i]; // запомним элемент
                    arraySort[i] = arraySort[i + 1];
                    arraySort[i + 1] = buffer;
                    swap = true;
                }
            }
            lastElement--;
        }
        while (swap);
    }



    static double[] mul(double[][] matrix, double[] vector) {
        double[] multiMatrixVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                multiMatrixVector[i] = multiMatrixVector[i] + matrix[i][j] * vector[j];
            }
        }
        return multiMatrixVector;

    }


    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] multiMatrixMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    multiMatrixMatrix[i][j] = multiMatrixMatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }

            }
        }
        return multiMatrixMatrix;
    }
}
