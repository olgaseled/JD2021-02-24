package by.it.seledtsova.jd01_01;

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
    Scanner sc = new Scanner (System.in);
        System.out.println("Enter numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a + b;
        // обычный
        System.out.println("DEC:"+a+"+"+b+"="+sum);
        // Бинарный формат числа
        String bin1 = Integer.toBinaryString(a);
        String bin2 = Integer.toBinaryString(b);
        String bin3 = Integer.toBinaryString(sum);
        System.out.println("BIN:"+bin1+"+"+bin2+"="+bin3);
        // Шеснадцатиричная форма
        String Hex1 = Integer.toHexString(a);
        String Hex2 = Integer.toHexString(b);
        String Hex3 = Integer.toHexString(sum);
        System.out.println("HEX:"+Hex1+"+"+Hex2+"="+Hex3);

        // Восьмиричная форма
        String Oct1 = Integer.toOctalString(a);
        String Oct2 = Integer.toOctalString(b);
        String Oct3 = Integer.toOctalString(sum);
        System.out.println("OCT:"+Oct1+"+"+Oct2+"="+Oct3);


    }
    }





