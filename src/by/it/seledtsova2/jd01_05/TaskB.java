package by.it.seledtsova2.jd01_05;

import java.io.OutputStream;

public class TaskB {
    public static void main(String[] args) {
        stepB1();
        stepB2();
    }

    private static void stepB2() {
        double b = 0;
        double a=0;
        for (double x = -5.5; x < 2; x = x + 0.5) {
            if (-2 < x / 2 && x / 2 <= -1) {
               b = Math.sin(x * x);
               a=Math.log10(Math.abs(b+2.74));
                System.out.println(a);
            } else if(-1<x/2 && x/2<0.2) {
                b = Math.cos(x * x);
                a=Math.log10(Math.abs(b+2.74));
                System.out.println(a);
            } else if (x/2==0.2) {
                b=1/(Math.tan(x*x));
                a=Math.log10(Math.abs(b+2.74));
                System.out.println(a);
            } else {
                System.out.println("Значение не определены");
            }

            }
    }

        private static void stepB1 () {
            double y = 0;
            for (double a = 0; a <= 2; a = a + 0.2) {
                for (int x = 0; x <= 6; x++) {
                    y = y + (Math.pow(7, a) - Math.cos(x));
                    System.out.println("При a= " + a + " и x= " + x + " ,у= " + y);
                }
            }
        }
    }

