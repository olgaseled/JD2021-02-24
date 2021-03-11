package by.it.kishkar.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
    }
    private static void step1(){
        for (double a = 0; a <= 2; a = a + 0.2) {
double y=0.00;
            for (int x = 1; x <= 6; x++) {
                y+=(pow(7, a)-cos(x));

            }
            System.out.printf("при a=%6.2f f=%g\n", a, y);
        }
    }
}
