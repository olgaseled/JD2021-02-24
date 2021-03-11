package by.it.korotkevich.jd01_03;


class InOut {
    static double[] getArray(String line) {
        String[] array = line.trim().split(" ");
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i]=Double.parseDouble(array[i]);
        }
        return(result);
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-7.4f ", name, i, arr[i]);
            if ((i+1)%columnCount==0 || i+1==arr.length) {
                System.out.println();
            }
        }
    }

}
