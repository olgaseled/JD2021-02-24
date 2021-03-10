package by.it.savchenko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }


    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = pow(7, a) * 6;

            for (double x = 1; x <= 6; x++) {
                y = y - cos(x);
                System.out.println("При а = " + a + " сумма y =" + y);
            }
        }
    }


    private static void step2() {

        for (double x = -6; x < 2; x = x + 0.5) {
            double b;
            double a;
            if (-2 < x / 2 && x / 2 <= -1) {
                b = sin(pow(x, 2));
                a = log(abs(b + 2.74));
                System.out.println("При x/2=" + x + " a = " + a);
            } else if (-1 < x / 2 && x / 2 < 0.2) {
                b = cos(pow(x, 2));
                a = log(abs(b + 2.74));
                System.out.println("При x/2=" + x +" a = " + a);
            } else if (x / 2 == 0.2) {
                b = tan(pow(x, 2));
                a = log(abs(b + 2.74));
                System.out.println("При x/2=" + x + " a = " + a);
            } else {
                System.out.println("При x/2=" + x + " вычисления не определены");

            }

        }
    }
}