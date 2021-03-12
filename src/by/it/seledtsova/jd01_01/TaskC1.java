package by.it.seledtsova.jd01_01;

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
    Scanner sc = new Scanner(System.in);
    {
        System.out.println("Enter the first number:");
        int a = sc.nextInt();
        System.out.println("Enter the second number");
        int b = sc.nextInt();
        sc.close();
        int sum = a + b;
        System.out.println("Sum = " + sum);
    }
}
}









