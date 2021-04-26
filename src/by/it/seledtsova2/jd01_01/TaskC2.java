package by.it.seledtsova2.jd01_01;

import java.util.Scanner;

public class TaskC2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a= scanner.nextInt();
        int b=scanner.nextInt();
        int sum=a+b;
        // десятичный
        System.out.println("DEC:"+a+"+"+b+"="+sum);

        // Бинарный формат числа
        String binA=Integer.toBinaryString(a);
        String binB=Integer.toBinaryString(b);
        String binSum=Integer.toBinaryString(sum);
        System.out.println("BIN:"+binA+"+"+binB+"="+binSum);

        //Шеснадцатиричная форма
        String hexA=Integer.toHexString(a);
        String hexB=Integer.toHexString(b);
        String hexSum=Integer.toHexString(sum);
        System.out.println("HEX:"+hexA+"+"+hexB+"="+hexSum);

        // Восьмиричная форма
        String octA=Integer.toOctalString(a);
        String octB=Integer.toOctalString(b);
        String octSum=Integer.toOctalString(sum);
        System.out.println("OCT:"+octA+"+"+octB+"="+octSum);
    }
}
