package by.it.baranov.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void  main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr= new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= scanner.nextInt();

        }
        step1(arr);
        step2(arr);
        step3(arr);
    }



    private static void step1(int[] arr) {
        int min=arr[0];
        int max=arr[0];
        for (int elemnt : arr) {
            if (min > elemnt) min = elemnt;
            if (max < elemnt) max = elemnt;}

        System.out.println(min+" "+max);

    }

    private static void step2(int[] arr) {
        double avg=arr[0];
        for (int elemnt : arr) {
            avg += elemnt;
        }

        avg=avg/ arr.length;

            for (int elemnt : arr) {
             if (elemnt<avg)
                 System.out.print(elemnt);
             }

        }
    private static void step3(int[] arr) {
        int min=arr[0];
        for (int elemnt : arr)
        { if (min > elemnt) min = elemnt;}
                for (int i = arr.length-1; i >=0; i--)
                {if (arr[i] == min) System.out.print(i+" ");}

            }}













