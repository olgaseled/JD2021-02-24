package by.it.dudko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    
    public static void main(String[] args) {
        step1();
        step2();
    }
    
    private static void step1() {
        for (double a=0; a<=2; a+=0.2) {
            double y=0;
            for (int x=1; x<=6; x++) {
                y += pow(7, a) - cos((double)x);
            }
            System.out.printf("При a=%.2f y=%f\n", a, y);
        }
    }
    
    private static void step2() {
        double x = -6;
        final double THRESHOLD = 1E-8;
        
        do {
            x+=0.5;
            double beta = 0.0;
            boolean isFound = false;

            if (-2 < x/2 && x/2 <= -1) {
                beta = sin(x*x);
                isFound = true;
            } else if (-1 < x/2 && x/2 < 0.2) {
                beta = cos(x*x);
                isFound = true;
            } else if (abs(x/2 - 0.2) < THRESHOLD) {
                beta = cos(x*x) / sin(x*x);
                isFound = true;
            }
            if (isFound) {
                double alpha = log10(abs(beta + 2.74));
                System.out.printf("При x/2=%.2f a=%f\n", x/2, alpha);
            } else {    
                System.out.printf("При x/2=%.2f вычисления не определены\n", x/2);
            }
        } while (x+0.5 < 2);
    }
}