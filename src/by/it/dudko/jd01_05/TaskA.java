package by.it.dudko.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        double x = 0.3;
        double a = 756.13;

        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log((a - 1.12 * x) / 4);

        double z = part1 - part2 - part3;
        System.out.printf("при a=%-10.3f и x=%f y=%f\n", a, x, z);
    }
}
