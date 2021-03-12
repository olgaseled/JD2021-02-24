package by.it.seledtsova.jd01_04;

/**
 * исками максимум и минимум
 */

public class Helper {
    public static void main(String[] args) {
        double array[] = new double[]{1, 5, 87, 36, 2};
        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));
        Helper.sort(array);
        for (double element : array) {
            System.out.println(element + " ");
        }
    }

    public static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        int indexMax = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                indexMax = i;
            }
        }
        return arr[indexMax];
    }


    public static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        int indexMin = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                indexMin = i;
            }
        }
        return arr[indexMin];
    }

    static void sort(double[] arr) {
        int n = arr.length;
        double temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;

                }

            }

        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                z[i] = z[i] + matrix[i][j] * vector[j];

        return z;

    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double [][] z = new double[matrixLeft.length] [matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    //z[i][j]=z[i][j]+matrixLeft[i][k]+matrixRight[k][j];
                    z [i][j] += matrixLeft[i][k] * matrixRight[k][j];
                return z;

                }

            }



















