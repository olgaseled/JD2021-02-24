package by.it.korotkevich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }


    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        String[] array = line.trim().split(" ");
        double[] resultArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            resultArray[i] = Double.parseDouble(array[i]);
        }

        double firstElement = resultArray[0];
        double lastElement = resultArray[resultArray.length - 1];

        for (int i = 0; i < resultArray.length; i++) {
            int columnCount = 5;
            System.out.printf("%s[% -3d]=%-7.4f ", "V", i, resultArray[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == resultArray.length) {
                System.out.println();
            }
        }

        boolean swap;
        double last = resultArray.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (resultArray[j] > resultArray[j + 1]) {
                    double buffer = resultArray[j];
                    resultArray[j] = resultArray[j + 1];
                    resultArray[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);

        for (int i = 0; i < resultArray.length; i++) {
            int columnCount = 4;
            System.out.printf("%s[% -3d]=%-7.4f ", "V", i, resultArray[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == resultArray.length) {
                System.out.println();
            }
        }

        int indexOfFirstElement = Arrays.binarySearch(resultArray, firstElement);
        int indexOfLastElement = Arrays.binarySearch(resultArray, lastElement);
        System.out.println("Index of first element=" + indexOfFirstElement);
        System.out.println("Index of last element=" + indexOfLastElement);
    }
}
