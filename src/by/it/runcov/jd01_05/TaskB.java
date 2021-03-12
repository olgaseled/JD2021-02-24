package by.it.runcov.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (double x = 1; x <= 6; x++) {
                double y = ((pow(7, a)) - cos(x));
                System.out.printf("a=%2.2f y = %g\n", a, y);
            }
        }
    }

    private static void step2() {
    }
}
