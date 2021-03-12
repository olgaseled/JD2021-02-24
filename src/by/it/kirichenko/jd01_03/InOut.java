package by.it.kirichenko.jd01_03;

import java.util.Arrays;

public class InOut {
    public static void main(String[] args) {
        double[] array = getArray("1 2 3 4.6");
        System.out.println(Arrays.toString(array));
    }

    /**
     *
     * @param line Input String
     * @return Array with values from Input
     */
    public static double[] getArray(String line){
        line = line.trim();
        String[] stringArray = line.split(" ");
        double[] returnArray = new double[stringArray.length];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i]=Double.parseDouble(stringArray[i]);
        }
        return returnArray;
    }

    /**
     *
     * @param array
     */
    public static void printArray(double[] array){
        for (double value: array){
            System.out.println(value);
        }
    }

    public static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ",name,i,array[i]);
            if((i+1)%columnCount==0 || i==array.length - 1){
                System.out.println();
            }
        }
    }
}
