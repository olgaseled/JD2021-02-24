package by.it.belazarovich.jd01_04;

import by.it.zmushko.jd01_03.Helper;
import by.it.zmushko.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
        printMulTable();
    }



    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {

                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }
    public static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double start = array[0];
        double stop = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 5);
        int indexFirst = Arrays.binarySearch(array, start);
        System.out.printf("first element=%1d", indexFirst);
        System.out.println();
        int indexLast = Arrays.binarySearch(array, stop);
        System.out.printf("last element=%1d", indexLast);
        System.out.println();
    }}
