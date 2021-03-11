package by.it.kirichenko.jd01_01;

import java.math.BigInteger;
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

        int sum = a + b;


        BigInteger aBI = new BigInteger(String.valueOf(a));
        BigInteger bBI = new BigInteger(String.valueOf(b));
        BigInteger sumBI = new BigInteger(String.valueOf(sum));

        System.out.println("DEC:" + a + '+' + b + '=' + sum);
        System.out.println("BIN:" + aBI.toString(2) + '+' + bBI.toString(2) + '=' + sumBI.toString(2));
        System.out.println("HEX:" + aBI.toString(16) + '+' + bBI.toString(16) + '=' + sumBI.toString(16));
        System.out.println("OCT:" + aBI.toString(8) + '+' + bBI.toString(8) + '=' + sumBI.toString(8));
    }

}
