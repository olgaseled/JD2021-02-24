package by.it.khrolovich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        Step1();
        Step2();
    }

    private static void Step1() {
        double deltaA = 0.2;
        for (double a = 0; a <= 2; a = a + deltaA) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y = y + pow(7, a) - cos(x);
            }
            System.out.printf("For a=%f y=%f\n", a, y);
        }
    }

    private static void Step2() {
        double deltaX = 0.5;
        for (double x = -6 + deltaX; x < 2; x = x + deltaX) {
            double betta = 0;
            boolean flag = false;
            if (x / 2 <= -1 && x / 2 > -2) {
                betta = sin(x * x);
            } else if (x / 2 < 0.2 && x / 2 > -1) {
                betta = cos(x * x);
            } else if (x / 2 == 0.2) {
                betta = 1.0 / tan(x * x);
            } else {
                flag = true;
            }
            if (flag) {
                System.out.printf("For x/2=%f вычисления не определены\n", x / 2);
            } else {
                double alfa = log10(abs(betta + 2.74));
                System.out.printf("For x/2=%f a=%f\n", x / 2, alfa);
            }
        }
    }
}
