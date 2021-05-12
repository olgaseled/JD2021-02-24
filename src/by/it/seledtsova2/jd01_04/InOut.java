package by.it.seledtsova2.jd01_04;

public class InOut {
    static double[] getArray(String line) {
        // 1 2 3 4 5.5874
        String[] strArray = line.split(" ");
        double[] res = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            res[i] = Double.parseDouble(strArray[i]);

        }
        return res;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");

        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arr.length)
                System.out.println();
        }
    }
}




