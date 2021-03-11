package by.it.maksimova.jd01_05;


import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
//𝑦=   Σ(7𝑎−cos𝑥)где0≤𝑎≤2;Δ𝑎=0,2;

        // при а = 0, х=1 у=1, х=2 у=2,... , х=6 у=6, у1+у2+у3+у4+у5+у6=у
        //     при а = 0,2, х=1 у=1, х=2 у=2,... , х=6 у=6, у1+у2+у3+у4+у5+у6=ус
        //
        double sum = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (int x = 1; x <= 6; x++) {

                double y = pow(7, a) - cos(x);
                sum += y;
            }
            System.out.println(sum);
        }
    }

    private static void step2() {
        for (double x = -5.5; x < 2; x = x + 0.5) {

            if (x / 2 > -2 && x / 2 <= -1) {
                double b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%3.2f a=%f\n", x / 2, a);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                double b = cos(x * x);
                double a = log10 (abs(b + 2.74));
                System.out.printf("При x/2=%3.2f a=%f\n", x / 2, a);
            } else if (x / 2 == 0.2) {
                double b = cos(x * x) / sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%3.2f a=%f\n", x / 2, a);
            } else if (x / 2 <= -2 || x / 2 > 0.2) {
                System.out.printf("При x/2=%3.2f вычисления не определены\n", x / 2);
            }
        }
    }
}
