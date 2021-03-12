package by.it.maksimova.jd01_02;

import java.util.Scanner;

public class TaskB {
    private static int[][] arr;

    public static void main(String[] args) {
        step1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 12");
        int month = scanner.nextInt();
        step2(month);
        System.out.println("Введите 3 дробных числа");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step3(a, b, c);

    }


    private static void step1() {
        int[][] arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[0][0] = 1;
                arr[0][1] = 2;
                arr[0][2] = 3;
                arr[0][3] = 4;
                arr[0][4] = 5;
                arr[1][0] = 6;
                arr[1][1] = 7;
                arr[1][2] = 8;
                arr[1][3] = 9;
                arr[1][4] = 10;
                arr[2][0] = 11;
                arr[2][1] = 12;
                arr[2][2] = 13;
                arr[2][3] = 14;
                arr[2][4] = 15;
                arr[3][0] = 16;
                arr[3][1] = 17;
                arr[3][2] = 18;
                arr[3][3] = 19;
                arr[3][4] = 20;
                arr[4][0] = 21;
                arr[4][1] = 22;
                arr[4][2] = 23;
                arr[4][3] = 24;
                arr[4][4] = 25;

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
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
                break;
        }


    }

    private static void step3(double a, double b, double c) {

        double D=(b*b)-(4*a*c);
        if (D<0) {
            System.out.println("корней нет");
        }
        else if  (D==0) {
            double x=-b/(2*a);
            System.out.println(x);
        }
        else  {
            double x1=(-b+Math.sqrt(D))/(2*a);
            double x2=(-b-Math.sqrt(D))/(2*a);
            System.out.println(x1+" "+x2);
        }
    }
}