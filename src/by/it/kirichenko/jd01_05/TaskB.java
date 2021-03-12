package by.it.kirichenko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При a=%1.2f Сумма y =  %e\n", a, y);
            y = 0;
        }
    }

    private static void step5() {
        double a=0;
        for (double x = -5.5; x < 2; x += 0.5) {
            if (-2 < x / 2 & x / 2 <= -1){
                a=log10(abs(sin(x*x)+2.74));
                System.out.printf("При x=%1.1f a =  %e\n", x, a);
            }
            if(-1 < x / 2 & x / 2 < 0.2){
                a=log10(abs(cos(x*x)+2.74));
                System.out.printf("При x=%1.1f a =  %e\n", x, a);
            }
            if(x / 2 == 0.2){
                a=log10(abs(1/tan(x*x)+2.74));
                System.out.printf("При x=%1.1f a =  %e\n", x, a);
            }
            else{
                System.out.printf("Решений нет\n");
            }
        }
    }
}
