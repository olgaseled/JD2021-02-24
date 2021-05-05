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
        step3(array);
    }


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
        System.out.println();
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
        System.out.println();
    }

    /*
    Найти и вывести номер (т.е. индекс) самого маленького числа. Если же таких чисел будет несколько,
    вывести все найденные индексы минимума через пробел в порядке убывания.
     */
    private static void step3(int[] array) {
        int min = array[0];
        for (int element: array) {
            if (element<min) {
                min=element;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) { // обратный порядок
                if (array[i] == min) {
                    System.out.print(i + " ");
                    }
            }
        System.out.println();
    }
}



