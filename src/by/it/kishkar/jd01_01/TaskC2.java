package by.it.kishkar.jd01_01;

import javax.lang.model.element.NestingKind;
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
        Scanner in=new Scanner(System.in);
        System.out.println("Ввод чисел");
          int a=in.nextInt();
          int b=in.nextInt();
         int result=a+b;
         //обычный
        System.out.println("DEC:"+a+"+"+b+"="+result);
         //бинарка
        String bina= Integer.toBinaryString(a);
        String binb= Integer.toBinaryString(b);
        String binresult= Integer.toBinaryString(result);
            System.out.println("BIN:"+bina+"+"+binb+"="+binresult);
            //шестнадцатка
        String hexa= Integer.toHexString(a);
        String hexb= Integer.toHexString(b);
        String hexresult= Integer.toHexString(result);
             System.out.println("HEX:"+hexa+"+"+hexb+"="+hexresult);

            //восьмиричка
        String octa= Integer.toOctalString(a);
        String octb= Integer.toOctalString(b);
        String octresult= Integer.toOctalString(result);
        System.out.println("OCT:"+octa+"+"+octb+"="+octresult);
    }
}