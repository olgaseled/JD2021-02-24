package by.it.seledtsova2.jd01_02;

import java.util.Arrays;
import java.util.Scanner;


public class TaskB {
    public static void main(String[] args) {
        step1();
    }

    /*
step1()выводит числа от 1 до 25в виде матрицы N x N слева направо и сверхувниз (т.е. N = 5).
 После каждого числа один пробел.
 */
    private static void step1() {
        for (int i = 1; i <26 ; i++) {
            System.out.print(i+" ");
            if (i%5==0) {
            System.out.println();
            }



        }
    }
}

