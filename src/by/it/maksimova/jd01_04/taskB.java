package by.it.maksimova.jd01_04;

import java.util.Scanner;



//Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца).
//Зарплаты имеют тип int.
//Нужно для каждой фамилии выводить подсказку
//После подсказки можно через пробел вводить с консоли 4 цифры зарплат по кварталам(nextInt() в сканере).
//Постройте в консоли таблицу доходов людей по кварталам с фамилиями и итогом за год в последней колонке.
//               B2. Посчитайте и выведите общую сумму всех выплат и среднеарифметическую квартальнуюзарплатус точностью как минимум до 4 -го знака .
public class taskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleNumber = scanner.nextInt();
        String[] arrayPeopleLastName = new String [peopleNumber];
        for (int i = 0; i < peopleNumber; i++) {
            arrayPeopleLastName[i] = scanner.next();
            System.out.println("Введите зарплату для " + arrayPeopleLastName[i]);
            int salary = scanner.nextInt();
                    }

//        for (int i = 0; i < number; i++) {
//            System.out.println("Введите зарплату для " + arrayPeopleLastName[i]);
//            for (int j = 0; j < 4; j++) {
//                int salary = scanner.nextInt();
//            }
//        }
//
//        System.out.println("-".repeat(100));

                  }
        }


