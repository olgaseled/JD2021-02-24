package by.it.belazarovich.jd01_01;

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

        Scanner a = new Scanner(System.in);
        System.out.println("Введите числа:");
        //десятичн.
        int j = a.nextInt();
        int i = a.nextInt();
        int sum = i + j;

        System.out.println("DEC:" + j + "+" + i + "=" + sum);

        //бинарный
        String jbi = Integer.toBinaryString(j);
        String ibi = Integer.toBinaryString(i);
        String sumbi = ibi + jbi;
        System.out.println("BIN:" + jbi + "+" + ibi + "=" + sumbi);


        //шеснадцатиричный

        String jhex = Integer.toHexString(j);
        String ihex = Integer.toHexString(i);
        String sumhex = ihex + jhex;
        System.out.println("HEX:" + jhex + "+" + ihex + "=" + sumhex);

//восьмиричный

        String joct = Integer.toOctalString(j);
        String ioct = Integer.toOctalString(i);
        String sumoct = ioct + joct;
        System.out.println("OCT:" + joct + "+" + ioct + "=" + sumoct);

    }
}
