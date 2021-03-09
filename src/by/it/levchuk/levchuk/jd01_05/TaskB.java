package by.it.levchuk.levchuk.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = pow(7, a) * 6 - cos(1) - cos(2) - cos(3) - cos(4) - cos(5) - cos(6);
            for (int i = 0; i < 6; ++i) {
                System.out.printf("при а=%-10.3f x=%e \n ", a, y);

            }
        }
    }

    private static void task2() {
        double alfa;
        double beta;
        for (double x = -5.5; x < 1.5; x += 0.5) {
            if (x / 2 > -2 & x / 2 <= -1) {
                beta = sin(x * x);
                alfa = log10(abs(beta + 2.74));
                System.out.printf("При x=%.2f a = %f\n", x, alfa);
            } else if (x / 2 > -1 & x / 2 < 0.2) {
                beta = cos(x * x);
                alfa = log10(abs(beta + 2.74));
                System.out.printf("При x=%.2f a = %f\n", x, alfa);
            } else if (x / 2 == 0.2) {
                beta = 1 / (tan(pow(x, 2)));
                alfa = log10(abs(beta + 2.74));
                System.out.printf("При x=%.2f a = %f\n", x, alfa);
            } else {
                System.out.printf("При данном значении агрумента x=%.2f вычисления не возможны \n", x);

            }
        }
    }
}
