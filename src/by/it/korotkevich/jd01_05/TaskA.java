package by.it.korotkevich.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1() {
        double x = 0.3;
        double a = 756.13;
        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log((a - 1.12 * x) / 4);
        double z = part1 - part2 - part3;
        System.out.printf("z = %f", z);
    }

    private static void task2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2)) - pow(a + 1.5, 1.0 / 3) + a * pow(b, 5) - b / log(a * a);
        System.out.printf("y = %f", y);
    }

    private static void task3() {
        double x = 12.1;
        for (double a = -5; a <= 12; a += 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("a = %6.2f, f = %g\n", a, f);
        }
    }
}
