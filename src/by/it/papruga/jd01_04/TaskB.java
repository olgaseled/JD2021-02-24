package by.it.papruga.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] lastName = new String[n];
        int sumSalary = 0;
        int quarter1 = 0;
        int quarter2 = 0;
        int quarter3 = 0;
        int quarter4 = 0;

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

        for (int i = 0; i < n; i++) { sumSalary = sumSalary + Arrays.stream(salary[i]).sum(); }

        for (int i = 0; i < n; i++) { quarter1 = quarter1 + salary[i][0]; } quarter1 = quarter1/n;
        for (int i = 0; i < n; i++) { quarter2 = quarter2 + salary[i][1]; } quarter2 = quarter2/n;
        for (int i = 0; i < n; i++) { quarter3 = quarter3 + salary[i][2]; } quarter3 = quarter3/n;
        for (int i = 0; i < n; i++) { quarter4 = quarter4 + salary[i][3]; } quarter4 = quarter4/n;
        double averageSalary = (double) (quarter1 + quarter2 + quarter3 + quarter4) / 4;

        System.out.println("-".repeat(60));
        System.out.println("Фамилия  Квартал1  Квартал2   Квартал3   Квартал4   Итого");
        System.out.println("-".repeat(60));
        for (int i = 0; i < n; i++) {
            System.out.printf("%-9s: %-9d %-9d %-9d %-9d %-9d \n", lastName[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], Arrays.stream(salary[i]).sum());
        }
        System.out.println("-".repeat(60));
        System.out.println("Итого " + sumSalary);
        System.out.printf("Средняя %.4f", averageSalary);

    }


}
