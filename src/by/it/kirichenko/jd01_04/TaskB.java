package by.it.kirichenko.jd01_04;

import by.it.kirichenko.jd01_03.InOut;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //String line = scanner.nextLine();

        String[] arrayFIO = new String[n];
        for (int i = 0; i < arrayFIO.length; i++) {
            arrayFIO[i] = scanner.next();
        }

        int[][] salarys = new int[n][5];

        for (int i = 0; i < arrayFIO.length; i++) {
            System.out.println("Введите через пробел ЗП каждого квартала " + arrayFIO[i] + ":");
            for (int j = 0; j < 4; j++) {
                salarys[i][j] = scanner.nextInt();
            }
        }

        printSalary(arrayFIO, salarys);
    }

    private static void printSalary(String[] arrayFIO, int[][] salarys) {
        System.out.println("------------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("------------------------------------------------------");
        int sumAll = 0;
        float avgSalary = 0;
        for (int i = 0; i < arrayFIO.length; i++) {
            int sumYear = salarys[i][0]+salarys[i][1]+salarys[i][2]+salarys[i][3];
            sumAll += sumYear;
            avgSalary += (float) sumYear / 4.0;
            System.out.printf("%7s: %-10d%-10d%-10d%-10d%-5d%n",
                    arrayFIO[i],salarys[i][0],salarys[i][1],salarys[i][2],salarys[i][3],sumYear);

        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%-8s %-10d%n","Итого",sumAll);
        avgSalary = avgSalary / arrayFIO.length;
        System.out.printf("%-8s %-10.5f%n","Средняя",avgSalary);
    }
}
