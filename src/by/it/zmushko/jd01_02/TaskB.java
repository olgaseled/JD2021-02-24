package by.it.zmushko.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step1();
        step2(month);
        step3(a, b, c);
    }

    private static void step3(double a, double b, double c) {
        // ax^2+bx+c
        double diskriminant = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        if (diskriminant > 0) {
            double x1 = ((-b) + diskriminant) / (2 * a);
            double x2 = ((-b) - diskriminant) / (2 * a);
            System.out.println(x1 + " " + x2);
        } else if (diskriminant == 0) {
            double x3 = (-b) / (2 * a);
            System.out.println((int) x3);
        } else {
            System.out.println("корней нет");
        }
    }

    private static void step2(int mounth) {
        switch (mounth) {
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");
                break;
            }
        }
    }

    private static void step1() {
        int number = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }
}
