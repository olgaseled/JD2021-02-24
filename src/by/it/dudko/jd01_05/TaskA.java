package by.it.dudko.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }
    
    
    private static void step1() {
        double a = 756.13;
        double x = 0.3;

        double z = cos(pow(x * x + PI / 6, 5))
                - sqrt(x * pow(a, 3))
                    - log((a-1.12*x) / 4);
        
        
        System.out.printf("Для a=%.3f и x=%.3f z=%f\n", a, x, z);
    }
    
    
    private static void step2() {
        double a=1.21;
        double b=0.371;
        
        double y = tan(pow(a + b, 2)) - cbrt(a+1.5)
                + a*pow(b,5) - b / log(a*a);
        
        System.out.printf("Для a=%.3f и b=%.3f y=%.6f\n", a, b, y);
    }
    
    
    private static void step3() {
        double x=12.1;
        double step=3.75;
        
        for (double a=-5; a<=12; a+=3.75) {
            double f = pow(E,a*x) - 3.45*a;
            System.out.printf("При a=%.2f и x=%.1f f=%.6f\n", a, x, f);
        }
    }
}