package by.it.dudko.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        final int ARRAY_LENGTH = 10;
        int[] arr = new int[ARRAY_LENGTH];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            System.out.println((ARRAY_LENGTH - 1 - i > 0)
                    ? "Enter number:"
                    : "Enter last number");
            arr[i] = sc.nextInt();
        }

        step1(arr);
        step2(arr);
        step3(arr);
    }


    private static void step1(int[] arr) {
        int min = arr[0], max = arr[0];
        // get the lowest and the highest values of array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(min + " " + max);
    }


    private static void step2(int[] arr) {
        double sum = 0.0;
        for (int number : arr) {
            sum += number;
        }
        // calculate average value of array elements
        double avg = sum / arr.length;
        // print all the elements below average value
        for (int number : arr) {
            if (number < avg) {
                System.out.println(number);
            }
        }
    }


    private static void step3(int[] arr) {
        int min = arr[0];
        // get the lowest value of array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // concatenate indices of all the elements with lowest value
        // into the result string
        String minIndices = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min) {
                minIndices += i + " ";
            }
        }
        System.out.println(minIndices);
    }
}
