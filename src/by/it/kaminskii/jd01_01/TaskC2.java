package by.it.kaminskii.jd01_01;

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
                int i = sc.nextInt();
                int j = sc.nextInt();
                int k = i + j;
        System.out.println("DEC:" + i + "+" + j + "=" + k);

        String c = Integer.toBinaryString(i);
        String v = Integer.toBinaryString(j);
        String b = Integer.toBinaryString(k);
        System.out.println("BIN:" + c + "+" + v + "=" + b);

        String a = Integer.toHexString(i);
        String s = Integer.toHexString(j);
        String d = Integer.toHexString(k);
        System.out.println("HEX:" + a + "+" + s + "=" + d);

        String q = Integer.toOctalString(i);
        String w = Integer.toOctalString(j);
        String e = Integer.toOctalString(k);
        System.out.println("OCT:" + q + "+" + w + "=" + e);
    }
    }


