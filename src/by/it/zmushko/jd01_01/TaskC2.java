package by.it.zmushko.jd01_01;

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
        Scanner scanner = new Scanner(System.in);
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int sum = a + b;
        System.out.println("DEC:"+a+"+"+b+"="+sum);

        String a1 = Integer.toBinaryString(a);
        String b1 = Integer.toBinaryString(b);
        String sum1 = Integer.toBinaryString(sum);
        System.out.println("BIN:"+a1+"+"+b1+"="+sum1);

        String a2 = Integer.toHexString(a);
        String b2 = Integer.toHexString(b);
        String sum2 = Integer.toHexString(sum);
        System.out.println("HEX:"+a2+"+"+b2+"="+sum2);

        String a3 = Integer.toOctalString(a);
        String b3 = Integer.toOctalString(b);
        String sum3 = Integer.toOctalString(sum);
        System.out.println("OCT:"+a3+"+"+b3+"="+sum3);
    }

}
