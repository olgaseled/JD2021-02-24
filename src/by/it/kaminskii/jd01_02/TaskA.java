package by.it.kaminskii.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int element : arr) {
            if (element < min) {
                min = element;
            }

        }
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] arr) {

        double sum = 0;
        for (int element : arr) {
            sum = sum + element;
        }
        sum = sum / arr.length;
        for (int element : arr) {
            if (element < sum)
                System.out.print(element + " ");
        }

    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (element < min) {
                min = element;
            }
            for (int i = 9; i >= 0 ; i--) {
                if (arr[i] == min)
                    System.out.print(i + " ");
                }

            }

        }
    }


