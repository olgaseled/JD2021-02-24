package by.it.levchuk.levchuk.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74

Допускается свободное использование любых методов стандартной библиотеки
*/
class TaskC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Создание сканера для ввода данных с клавиатуры;
        try {
            // Исключение. Проверка на правильность ввода данных;
            System.out.println("Введите первое число и нажмите ВВОД");
            int i = sc.nextInt();
            // Ввод с клавиатуры первого числа;
            System.out.println("Введите второе число и нажмите ВВОД");
            int j = sc.nextInt();
            // Ввод с клавиатуры второго числа;
            int sum = i + j;
            // Математический оператор;
            String convert = Integer.toBinaryString(i);
            String convert1 = Integer.toBinaryString(j);
            String convert2 = Integer.toBinaryString(sum);
            // Конвертация в BIN;
            String convert3 = Integer.toHexString(i);
            String convert4 = Integer.toHexString(j);
            String convert5 = Integer.toHexString(sum);
            // Конвертация в HEX;
            String convert6 = Integer.toOctalString(i);
            String convert7 = Integer.toOctalString(j);
            String convert8 = Integer.toOctalString(sum);
            // Конвертация в OCT;
            System.out.println("DEC" + ":" + i + "+" + j + "=" + sum);
            System.out.println("BIN" + ":" + convert + "+" + convert1 + "=" + convert2);
            System.out.println("HEX" + ":" + convert3 + "+" + convert4 + "=" + convert5);
            System.out.println("OCT" + ":" + convert6 + "+" + convert7 + "=" + convert8);
            // Вывод данных;
        } catch (Exception e) {
            System.out.println("Неверные данные");
            // Вывод сообщения о ошибке;
        }

    }

}
