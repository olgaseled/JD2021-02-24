package by.it.korotkevich.jd01_01;

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
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a+b;

        String a_binary = Integer.toBinaryString(a);
        String b_binary = Integer.toBinaryString(b);
        String c_binary = Integer.toBinaryString(c);

        String a_hex = Integer.toHexString(a);
        String b_hex = Integer.toHexString(b);
        String c_hex = Integer.toHexString(c);

        String a_octal = Integer.toOctalString(a);
        String b_octal = Integer.toOctalString(b);
        String c_octal = Integer.toOctalString(c);

        System.out.println("DEC:"+a+"+"+b+"="+c);
        System.out.println("BIN:"+a_binary+"+"+b_binary+"="+c_binary);
        System.out.println("HEX:"+a_hex+"+"+b_hex+"="+c_hex);
        System.out.println("OCT:"+a_octal+"+"+b_octal+"="+c_octal);

    }

}
