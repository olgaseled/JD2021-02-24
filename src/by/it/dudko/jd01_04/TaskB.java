package by.it.dudko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of employees");
        int employeesNumber = sc.nextInt();
        String[] employees = new String[employeesNumber];
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Input employee name");
            employees[i] = sc.next();
        }
        final int QUARTERS_PER_YEAR = 4;
        int[][] employeeSalary = new int[employeesNumber][QUARTERS_PER_YEAR];
        for (int i = 0; i < employeesNumber; i++) {
            System.out.printf("Input salary by quarter for %s. Separate integer values by space\n", employees[i]);
            for (int quarter = 0; quarter < QUARTERS_PER_YEAR; quarter++) {
                employeeSalary[i][quarter] = sc.nextInt();
            }
        }

        printSalaries(employees, employeeSalary);
        int totalPayments = getTotalPayments(employeeSalary);
        double avgQuarterSalary = getAvgQuarterSalary(employeeSalary);
        printTotalInfo(totalPayments, avgQuarterSalary);

    }


    private static int getTotalPayments(int[][] employeesSalaries) {
        int acc = 0;
        for (int[] quarterSalaries : employeesSalaries) {
            for (int quarterSalary : quarterSalaries) {
                acc += quarterSalary;
            }
        }
        return acc;
    }


    private static double getAvgQuarterSalary(int[][] employeesSalaries) {
        double avgQuarterSalary = 0.0;
        final int QUARTERS_PER_YEAR = 4;
        final double EMPLOYEES_NUMBER = employeesSalaries.length;

        int[] quarterTotalSalaries = new int[QUARTERS_PER_YEAR];
        for (int[] quarterSalaries : employeesSalaries) {
            for (int quarter = 0; quarter < quarterSalaries.length; quarter++) {
                quarterTotalSalaries[quarter] += quarterSalaries[quarter];
            }
        }
        for (int quarterTotalSalary : quarterTotalSalaries) {
            avgQuarterSalary += quarterTotalSalary / EMPLOYEES_NUMBER;
        }

        return avgQuarterSalary / QUARTERS_PER_YEAR;
    }


    static void printSalaries(String[] employees, int[][] employeesSalaries) {
        String divider = new String(new char[70]).replace("\0", "-");
        System.out.println(divider);
        System.out.printf("%18s   %-10s %-10s %-10s %-10s %-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println(divider);
        for (int i = 0; i < employeesSalaries.length; i++) {
            int yearSalary = 0;
            System.out.printf("%18s:  ", employees[i]);
            int[] quarterSalaries = employeesSalaries[i];
            for (int quarterSalary : quarterSalaries) {
                yearSalary += quarterSalary;
                System.out.printf("%-10d ", quarterSalary);
            }
            System.out.printf("%-8d\n", yearSalary);
        }
        System.out.println(divider);
    }

    private static void printTotalInfo(int totalPayments, double avgQuarterSalary) {
        System.out.printf("%-18s   %-10d\n", "Итого", totalPayments);
        System.out.printf("%-18s   %-10.6f\n", "Средняя", avgQuarterSalary);
    }
}
