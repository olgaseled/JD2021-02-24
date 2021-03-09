package by.it.khrolovich.jd01_03;

import java.util.Arrays;

public class InOut {

    /**
     * @param line input line
     * @return output array
     */
    public static double[] getArray(String line) {

        line = line.trim();
        String[] stringArray = line.split(" ");
        double[] returnArray = new double[stringArray.length];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = Double.parseDouble(stringArray[i]);
        }
        return returnArray;
    }

    /**
     * Simple print to console
     *
     * @param array Intput Array
     */
    public static void printArray(double[] array) {
        for (double v : array) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    /**
     * Formatted print to console
     *
     * @param array       Intput Array
     * @param name        Letter Array
     * @param columnCount width output
     */
    public static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            if (((i + 1) % columnCount == 0) || (i == array.length - 1)) {
                System.out.println();
            }
        }
    }
}
