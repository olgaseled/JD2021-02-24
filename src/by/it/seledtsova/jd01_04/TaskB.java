package by.it.seledtsova.jd01_04;
//Введите с консоли число людей n(nextInt() в сканере).
//Затем введите одномерный массив их фамилий (next() в сканере).
//Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца).
//Зарплаты имеют тип int.
//Нужно для каждой фамилии выводить подсказку
//После подсказки можно через пробел вводить с консоли 4 цифры зарплат по кварталам(nextInt() в сканере).
//Постройте в консоли таблицу доходов людей по кварталам с фамилиями и итогом за год в последней колонке.


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // количество людей 3
        String[] lastNames = new String[n];
        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i] = scanner.next(); // фамилии сотрудников
        }
        int[][] salaryArr = new int[n][4]; // создала массив з/п сотрудников с фамилиями
        for (int i = 0; i < salaryArr.length; i++) {
            System.out.printf("Введите зарплату для %s\n", lastNames[i]);//вводим з/п сотрудников
            for (int j = 0; j < salaryArr[0].length; j++) {
                salaryArr[i][j] = scanner.nextInt();
            }
            }


        int totalSalary = 0;
        for (int i = 0; i < salaryArr.length; ++i) {
            double sumRow = 0;
            for (int j = 0; j < salaryArr[0].length; j++) {
                sumRow += salaryArr[i][j];
                totalSalary = totalSalary + salaryArr[i][j];
            }
        }
            double averageSalary = 0;
            averageSalary = (double) totalSalary / (salaryArr.length * salaryArr[0].length);

            System.out.printf("%-8s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "ИТОГО");
            System.out.println("_______________________________________________________");
            for (int i = 0; i < salaryArr.length; i++) {
                System.out.printf("%-8s%-10s%-10s%-10s%-10s%-10s%n",
                        lastNames[i], salaryArr[i][0], salaryArr[i][1], salaryArr[i][2], salaryArr[i][3],
                        salaryArr[i][0] + salaryArr[i][1] + salaryArr[i][2] + salaryArr[i][3]);
            }
            System.out.println("________________________________________________________");
            System.out.printf("%-10s %-4s", "ИТОГО", totalSalary);
            System.out.println();
            System.out.printf("%-10s %-4s", "Средняя", averageSalary);

            }
        }



















             

 

























