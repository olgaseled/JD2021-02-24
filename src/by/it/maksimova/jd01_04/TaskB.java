package by.it.maksimova.jd01_04;

import java.util.Scanner;



//Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца).
//Зарплаты имеют тип int.
//Нужно для каждой фамилии выводить подсказку
//После подсказки можно через пробел вводить с консоли 4 цифры зарплат по кварталам(nextInt() в сканере).
//Постройте в консоли таблицу доходов людей по кварталам с фамилиями и итогом за год в последней колонке.
//               B2. Посчитайте и выведите общую сумму всех выплат и среднеарифметическую квартальнуюзарплатус точностью как минимум до 4 -го знака .
public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество человек");
        int peopleNumber = scanner.nextInt();
        String[] arrayPeopleLastName = new String[peopleNumber];
        System.out.println("Введите фамилии");
        for (int i = 0; i < arrayPeopleLastName.length; i++) {
            arrayPeopleLastName[i] = scanner.next();
        }


        int[][] salaries = new int[arrayPeopleLastName.length][4];
        for (int i = 0; i < arrayPeopleLastName.length; i++) {
            System.out.println("Введите зарплату для " + arrayPeopleLastName[i]);
            for (int j = 0; j < 4; j++) {
                salaries[i][j] = scanner.nextInt();
            }
        }

            System.out.println("-".repeat(100));
            System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
            System.out.println("-".repeat(100));
            int sum=0;
            int totalSum = 0;

            for (int i = 0; i < arrayPeopleLastName.length; i++) {
                System.out.printf("%7s:  ", arrayPeopleLastName[i]);
                sum=0;
                for (int j = 0; j < 4; j++) {
                    System.out.printf("%-8s  ", salaries[i][j]);
                    sum = sum + salaries[i][j];
                }

                totalSum = totalSum + sum;
                System.out.printf("%-5s  ", sum);
                System.out.println();
            }
            System.out.println("-".repeat(100));

            System.out.printf("%-10s %-10d\n", "Итого", totalSum);
            System.out.printf("%-10s %-10s", "Средняя", (double) totalSum / (peopleNumber * 4));


        }
    }



