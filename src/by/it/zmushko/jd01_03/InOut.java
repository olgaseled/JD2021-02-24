package by.it.zmushko.jd01_03;

public class InOut {

    /**
     * @param line - input string
     * @return - Array with double elements
     */
    public static double[] getArray(String line) {
        String[] arrayString = line.trim().split(" ");
        double[] returnArray = new double[arrayString.length];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = Double.parseDouble(arrayString[i]);
        }
        return returnArray;
    }


    public static void printArray(double[] arr) {
        for (double elements : arr) {
            System.out.print(elements + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1) {
                System.out.println();
            }
        }
    }
}
