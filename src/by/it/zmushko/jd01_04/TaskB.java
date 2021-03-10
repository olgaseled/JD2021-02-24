package by.it.zmushko.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPeople = scanner.nextInt(); // запрос количества людей
        String[] arrayWorker = new String[countPeople]; //создание массива сотрудников
        for (int i = 0; i < arrayWorker.length; i++) { //запись фамилий в массив сотрудников
            arrayWorker[i] = scanner.next();
        }
        double[][] arrayZar = new double[countPeople][4];
        for (int i = 0; i < arrayZar.length; i++) {
            System.out.printf("Введите зарплату для %s\n", arrayWorker[i]);
            for (int j = 0; j < arrayZar[0].length; j++) {
                arrayZar[i][j] = scanner.nextDouble();
            }
            System.out.println();
        }
        double allSum = 0;
        System.out.printf("-".repeat(55)+"\n");
        System.out.printf("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого\n");
        System.out.printf("-".repeat(55)+"\n");
        for (int i = 0; i < arrayZar.length; i++) {
            double sum = 0;
            System.out.printf("%7s: ", arrayWorker[i]);
            for (int j = 0; j < arrayZar[0].length; j++) {
                System.out.printf("%-10.0f", arrayZar[i][j]);
                sum += arrayZar[i][j];
                allSum += arrayZar[i][j];
            }
            System.out.printf("%-10.0f ", sum);
            System.out.println();
        }
        System.out.printf("-".repeat(55)+"\n");
        System.out.printf("Итого: %1.0f\n", allSum);
        double allZpKvart = 0;
        for (int j = 0; j < arrayZar[0].length; j++) {
            double srednZpKvart = 0;
            for (int i = 0; i < countPeople; i++) {
                srednZpKvart = srednZpKvart + arrayZar[i][j];
            }
            allZpKvart = allZpKvart + srednZpKvart / countPeople;
        }
        System.out.printf("Средняя: %.4f\n", allZpKvart/4);
    }


}
