package by.it.kaminskii.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {

        for (double a = 0.00; a <=2 ; a+= 0.2) {
            double y=0.00;
            for (int x = 1; x <=6; x++) {
                y += pow(7, a) - cos(x);
            }
                System.out.printf("При а=%3.2f y=%g\n",a, y);
            }

        }

    private static void step2() {
        double b = 0.0;
        for (double x = -5.5; x < 2; x+=0.5) {
           double x1= x/2;
            if(x1>-2 && x1<=-1){
                b = sin(x*x);
            }
            else if (x1>-1 && x1<0.2){
                b = cos(x*x);

            }
            else if (x1 == 0.2){
                b = cos(x*2)/sin(x*x);

            }
            else if(x1 < -2 || x1>0.2){
                System.out.printf("При x/2="+x1 + " вычисления не определены"+'\n');
                continue;
            }
            double a = log10(abs(b+2.74));
            System.out.printf("При x/2="+x1 + " a = "+ a+'\n');
        }
    }

    }
