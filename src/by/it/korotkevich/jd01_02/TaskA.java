package by.it.korotkevich.jd01_02;

import java.util.Scanner;

class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
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
            if (element > max) {
                max = element;
            }
            if (element < min) {
                min = element;
            }
        }
        System.out.print(min + " " + max);
        System.out.println();
    }

    private static void step2(int[] arr) {
        double average = 0;
        for (int element : arr) {
            average = average + element;
        }
        average = average / arr.length;
        for (int element : arr) {
            if (element < average) {
                System.out.print(element);
            }
        }
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (element < min) {
                min = element;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min) {
                System.out.print(i + " ");
            }
        }
    }

}
