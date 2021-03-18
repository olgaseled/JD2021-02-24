package by.it.seledtsova.jd01_04._classwork_.jd01_03;

class InOut {

    /**
     * @param line Input String
     * @return Array with values from Input String
     */
    static double[] getArray(String line) {
        line = line.trim();
        String[] stringArray = line.split(" ");
        double[] returnArray = new double[stringArray.length];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = Double.parseDouble(stringArray[i]);
        }
        return returnArray;
    }

    /**
     * Simple print to Console
     *
     * @param array Input Array
     */
    static void printArray(double[] array) {
        for (double value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Formatted print to Console
     *
     * @param array       Input Array
     * @param name        Letter Array
     * @param columnCount width output
     */
    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%1s[% -3d]=%-10.4f ", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || i == array.length - 1) {
                System.out.println();
            }
        }
    }
}
