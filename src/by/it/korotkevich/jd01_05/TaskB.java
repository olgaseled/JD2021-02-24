package by.it.korotkevich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y = y + (pow(7, a) - cos(x));
            }
            System.out.printf("При а=%3.2f Сумма y = %12.7f", a, y);
        }
    }
}
