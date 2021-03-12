package by.it.maksimova.jd01_04;

import java.util.Scanner;

public class TaskA {

public static void main(String[] args) {
        printMulTable();
    Scanner scanner = new Scanner(System.in);
    String sc = scanner.nextLine();
        buildOneDimArray(sc);
        }

    static void printMulTable() {
        int j = 0;
        int result = 0;
        for (int i = 2; i < 10; i++) {
            for (j = 2; j < 10; j++) {
                result = i * j;
                System.out.printf("%1d*%1d=%-3d", i, j, result);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++)
            if (array[i] == first)
            {
                System.out.println("Index of first element="+i);
                break;
            }

        for (int i = 0; i < array.length; i++)
            if (array[i] == last)
            {
                System.out.println("Index of last element="+i);
                break;

        }

    }
}