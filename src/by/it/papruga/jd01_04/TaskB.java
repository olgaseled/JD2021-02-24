package by.it.papruga.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] lastName = new String[n];
        int sumSalary = 0;
        for (int i = 0; i < n; i++) {
            lastName[i] = scanner.next();
        }

        int[][] salary = new int[n][4];

        for (int i = 0; i < n; i++) {

            System.out.println("Введите зарплату для " + lastName[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            sumSalary = sumSalary + Arrays.stream(salary[i]).sum();
        }
        System.out.println("-".repeat(60));
        System.out.println("Фамилия  Квартал1  Квартал2   Квартал3   Квартал4   Итого");
        System.out.println("-".repeat(60));
        for (int i = 0; i < n; i++) {
            System.out.printf("%-9s: %-9d %-9d %-9d %-9d %-9d \n", lastName[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], Arrays.stream(salary[i]).sum());
        }
        System.out.println("-".repeat(60));
        System.out.println("Итого " + sumSalary);
        //  System.out.printf("Средняя %.4f", averageSalary);
        System.out.printf("Средняя %.4f", ((float) sumSalary / 4) / 3);

    }


}
