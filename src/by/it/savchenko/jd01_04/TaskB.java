package by.it.savchenko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] worker = new String[n];
        int[][] salaries = new int[n][4];
        for (int i = 0; i < worker.length; i++) {
            String d = scanner.next();
            worker[i] = d;
        }

        for (int i = 0; i < worker.length; i++) {
            System.out.println("Введите зарплату для " + worker[i]);
            for (int j = 0; j < salaries.length + 1; j++) {
                int salary = scanner.nextInt();
                salaries[i][j] = salary;
            }
        }
        int sum1 = salaries[0][0] + salaries[0][1] + salaries[0][2] + salaries[0][3];
        int sum2 = salaries[1][0] + salaries[1][1] + salaries[1][2] + salaries[1][3];
        int sum3 = salaries[2][0] + salaries[2][1] + salaries[2][2] + salaries[2][3];
        int totalSum = sum1 + sum2 + sum3;
        double averageSalary = (double) totalSum / (salaries.length * salaries[0].length);

        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-10s%-12s%-12s%-12s%-12s%-12s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-10s%-12s%-12s%-12s%-12s%-12s%n", worker[0], salaries[0][0], salaries[0][1], salaries[0][2], salaries[0][3], sum1);
        System.out.printf("%-10s%-12s%-12s%-12s%-12s%-12s%n", worker[1], salaries[1][0], salaries[1][1], salaries[1][2], salaries[1][3], sum2);
        System.out.printf("%-10s%-12s%-12s%-12s%-12s%-12s%n", worker[2], salaries[2][0], salaries[2][1], salaries[2][2], salaries[2][3], sum3);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Итого " + totalSum);
        System.out.println("Среднее "+ averageSalary);
    }
}

