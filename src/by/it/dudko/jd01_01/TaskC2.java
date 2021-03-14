package by.it.dudko.jd01_01;

import java.util.Scanner;

import static java.lang.Integer.*;

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

    static String summarizer(int add1, int add2) {
        return "DEC:" + add1 + "+" + add2 + "=" + (add1 + add2) + '\n' +
                "BIN:" + toBinaryString(add1) + "+" + toBinaryString(add2) + "=" + toBinaryString(add1 + add2) + '\n' +
                "HEX:" + toHexString(add1) + "+" + toHexString(add2) + "=" + toHexString(add1 + add2) + '\n' +
                "OCT:" + toOctalString(add1) + "+" + toOctalString(add2) + "=" + toOctalString(add1 + add2) + '\n';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first integer:");
        int i1 = sc.nextInt();
        System.out.println("Enter second integer:");
        int i2 = sc.nextInt();
        System.out.println(summarizer(i1, i2));
    }
}
