package by.it.epam;

import java.util.Arrays;
import java.util.Scanner;


/*
 4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
 */
public class task4 {
    public static void main(String[] args) {

        stepFirst();
        stepSecond();
    }

    private static void stepSecond() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size");
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Enter the numbers");
            array[i] = scanner.nextInt();

        }
        System.out.println(Arrays.toString(array));
        int sum = 0;
        int composition = 1;
        for (int i = 0; i < arrayLength; i++) {
            sum = sum + array[i];
        }
        for (int i = 1; i < arrayLength; i++) {
            composition = composition * array[i];
        }
        System.out.println("Sum = "+sum);
        System.out.println("Composition = "+composition);


    }

    private static void stepFirst() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the numbers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = a * b * c;
        int e = a + b + c;
        System.out.println("Sum =" + d);
        System.out.println("Composition =" + e);
    }
}

