package by.it.belazarovich.jd01_04;


public class InOut {
    /**
     * @param line input string
     * @return Array
     */

    // public static void main(String[] args) {
    static double[] getArray(String line) {
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.println(element + " ");
        }
        System.out.println();
    }


    static void printArray(double[] arr, int columnCounnt) {
        for (int i = 0; i < arr.length; i++) {

            System.out.printf("%s[% -3d]=%f-10.4f ", "V", i, arr[i]);
            if ((i + 1) % columnCounnt == 0 || i + 1 == arr.length)
                System.out.println();

            InOut.printArray(arr, 3);
        }
    }


}