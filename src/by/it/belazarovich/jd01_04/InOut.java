package by.it.belazarovich.jd01_04;


public class InOut {
    /**
     * @param line input string
     * @return Array
     */

    // public static void main(String[] args) {
    static double[ ] getArray(String line){

        String[] strArr = line.split(" ");

        double [] res = new double[strArr.length];

        for (int i = 0; i < strArr.length ; i++) {

            res[i] = Double.parseDouble(strArr[i]);
        }

        return res;

    }

    static void printArray(double[ ] arr)

    {

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");

        }

        System.out.println();


    }

    static void printArray(double[ ] arr, String name, int columnCount)
    {

        int columCount = 0;

        for (int i = 0; i < arr.length; i++) {

            System.out.printf("%s[%d]=%-10.3f ", name, i, arr[i]);
            if ((i+1)%columnCount==0 || i+1==arr.length)
                System.out.println();
        }



    }


}
