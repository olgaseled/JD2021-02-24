package by.it.khrolovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] arrayName = new String[n];
        for (int i = 0; i < n; i++) {
            arrayName[i] = scanner.next();
        }
        int[][] arraySalary = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + arrayName[i]);
            for (int j = 0; j < 4; j++) {
                arraySalary[i][j] = scanner.nextInt();
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("------------------------------------------------------");
        int resSum = 0;
        int sum;
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s:  ", arrayName[i]);
            sum = 0;
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-8s  ", arraySalary[i][j]);
                sum = sum + arraySalary[i][j];

            }
            resSum = resSum + sum;
            System.out.printf("%-5s  ", sum);
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Итого    " + resSum);
        System.out.println("Средняя  " + (double) resSum / (n * 4));
    }
}
