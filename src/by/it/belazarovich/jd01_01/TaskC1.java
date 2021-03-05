package by.it.belazarovich.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/

class TaskC1 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Введите число 1: ");
        int i = a.nextInt();

       Scanner b = new Scanner(System.in);
       System.out.println("Введите число 2: ");
       int u = b.nextInt();
       int r=i+u;
       System.out.println("Sum = "+r  );


    }

}
