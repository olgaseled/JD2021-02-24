package by.it.seledtsova2.jd01_02;

import java.util.Scanner;


public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 12");
        int month = scanner.nextInt();
        step2(month);
        System.out.println("Введите число a=");
        double a=scanner.nextInt();
        System.out.println("Введите число b=");
        double b=scanner.nextInt();
        System.out.println("Введите число c=");
        double c=scanner.nextInt();
        step3(a,b,c);
    }

    private static void step1() {
        for (int i = 1; i < 26; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }
    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }

    }
/*
Рассчитайте и выведите корни (или один корень) квадратного уравнения.
Если корня нет, то нужно вывести сообщение “корней нет”.Параметры (a b c) уравнения нужно вводитьв main через
тот же Scanner и затем передавать в метод step3(double a, double b, double c).
  Для извлечения используйте метод Math.sqrt(дискриминант)
 */
//
    private static void step3 (double a, double b, double c) {
        double discrimenant=b*b-4*a*c;
        if (discrimenant<0) {
            System.out.println("корней нет");
        }else if (discrimenant==0) {
            double x=-b/(2*a);
            System.out.println("Дискриминант равен 0, значит уравнение умеет единственный корень x="+x);
        } else {
          double x1=(-b+Math.sqrt(discrimenant))/(2*a);
           double x2=(-b-Math.sqrt(discrimenant))/(2*a);
            System.out.println(x1+" "+x2);
        }
    }


}

