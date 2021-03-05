package by.it.baranov.jd01_01;

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
class TaskC2 {public static void main(String... args){
    {
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();
        int Result = a + b;
        System.out.print("DEC:" +a);
        System.out.print("+"+b);
        System.out.print("=" +Result);




    // Бинарный формат числа
    String m = Integer.toBinaryString(a);
    String d = Integer.toBinaryString(b);
    String f = Integer.toBinaryString(Result);
    System.out.println( );
    System.out.print("BIN:" +m);
    System.out.print("+"+d);
        System.out.print("=" +f);

    // Шеснадцатиричная форма
    //convert = Integer.toHexString(number);
    //System.out.println(convert);
        String l = Integer.toHexString(a);
        String x = Integer.toHexString(b);
        String s = Integer.toHexString(Result);
        System.out.println( );
        System.out.print("HEX:" +l);
        System.out.print("+"+x);
        System.out.print("=" +s);
    // Восьмиричная форма
    //convert = Integer.toOctalString(number);
    //System.out.println(convert);
        String k = Integer.toOctalString(a);
        String n = Integer.toOctalString(b);
        String t = Integer.toOctalString(Result);
        System.out.println( );
        System.out.print("OCT:" +k);
        System.out.print("+"+n);
        System.out.print("=" +t);



}}}
