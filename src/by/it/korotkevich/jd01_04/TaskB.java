package by.it.korotkevich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWorkers = scanner.nextInt();
        String[] names = new String[numberOfWorkers];

        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.next();
        }

        int[][] salaries = new int[numberOfWorkers][4];
        for (int i = 0; i < salaries.length; i++) {
            System.out.println("Введите зарплату для " + names[i]);
            for (int j = 0; j < salaries[i].length; j++) {
                salaries[i][j] = scanner.nextInt();
            }

        }

        int totalSalary = 0;
        for (int[] salary : salaries) {
            for (int i : salary) {
                totalSalary = totalSalary + i;
            }
        }
        double averageSalary = (double) totalSalary / (salaries.length * salaries[0].length);


        System.out.println("------------------------------------------------------");
        System.out.printf("%7s  %-10s%-10s%-10s%-10s%-5s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%7s  %-10d%-10d%-10d%-10d%-5d%n", names[i], salaries[i][0], salaries[i][1], salaries[i][2], salaries[i][3], salaries[i][0] + salaries[i][1] + salaries[i][2] + salaries[i][3]);
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%7s  %-10d%n", "Итого", totalSalary);
        System.out.printf("%7s  %-10.4f", "Средняя", averageSalary);

    }
}
