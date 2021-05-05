package by.it.seledtsova2.jd01_02;

import java.util.Scanner;

public class TaskA {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        step1(array);
        step2(array);
    }

    // 1 2 3 4 5 -1 -2 -3 -4 -5
    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println(min + " " + max);
    }

    /*
    Вывести на консоль те числа, значение которых строго меньше среднегоарифметического(типа double) в этом массиве.
     */

    private static void step2(int[] array) {
        double sum = 0;
        double average;
        for (int element : array) {
            sum = sum + element;
        }
        average = sum / array.length;
        System.out.println(sum);
        System.out.println(average);
        for (int i = 0; i < array.length; i++) {
            if (average > array[i]) {
                System.out.println(array[i]);
            }
        }


        }
    }

