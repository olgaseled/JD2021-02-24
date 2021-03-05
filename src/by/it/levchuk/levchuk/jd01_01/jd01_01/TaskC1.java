package by.it.levchuk.levchuk.jd01_01.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Создание сканера для ввода данных с клавиатуры;
        try { // Исключение. Проверка на правильность ввода данных;
            System.out.println("Введите первое число и нажмите ВВОД");
            int i = sc.nextInt();
            // Ввод с клавиатуры первого числа;
            System.out.println("Введите второе число и нажмите ВВОД");
            int j = sc.nextInt();
            // Ввод с клавиатуры второго числа;
            int sum = i + j;
            // Математический оператор;
            System.out.println("Sum" + " " + "=" + " " + sum);
            // Вывод суммы;
        } catch (Exception e) {
            System.out.println("Неверные данные");
            // Вывод сообщения о ошибке;
        }

    }

}
