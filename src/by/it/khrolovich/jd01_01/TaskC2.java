package by.it.khrolovich.jd01_01;

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
        int a = sc.nextInt();
        System.out.println("DEC:" + i + "+" + a + "=" + (i + a));

        String iBinary = Integer.toBinaryString(i);
        String aBinary = Integer.toBinaryString(a);
        String aiBinary = Integer.toBinaryString(i + a);
        System.out.println("BIN:" + iBinary + "+" + aBinary + "=" + aiBinary);

        String iHex = Integer.toHexString(i);
        String aHex = Integer.toHexString(a);
        String aiHex = Integer.toHexString(i + a);
        System.out.println("HEX:" + iHex + "+" + aHex + "=" + aiHex);

        String iOctal = Integer.toOctalString(i);
        String aOctal = Integer.toOctalString(a);
        String aiOctal = Integer.toOctalString(i + a);
        System.out.println("OCT:" + iOctal + "+" + aOctal + "=" + aiOctal);
    }
}
