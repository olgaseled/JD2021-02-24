package by.it.seledtsova2.jd01_01;

import java.util.Scanner;

// ввод 34 26
// вывод sum=26
public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        int sum=a+b;
        System.out.println("Sum = "+sum);
    }
}
