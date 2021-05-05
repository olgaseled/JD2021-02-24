package by.it.seledtsova2.jd01_02;

import java.util.Scanner;

public class TaskA {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
 //       for (int i = 0; i < array.length; i++) {
  //          System.out.print(array[i] + " ");
  //      }
        step1(array);
    }



    // 1 2 3 4 55 6 7 8 -9 0
    private static void step1(int[] array) {
        int min = array[0];
        int max=array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }

            if (max < array[i]) {
                max= array[i];

            }

        }
        System.out.println(min+" "+max);

    }
}
