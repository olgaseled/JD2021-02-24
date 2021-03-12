package by.it.maksimova.jd01_05;
import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1 ();
        step2 ();
        step3 ();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow((x*x+PI/6),5));
        double part2 = sqrt(x*pow(a,3));
        double part3 = log(abs((a-1.12*x)/4));
        double z = part1-part2-part3;
        System.out.println(z);

        double r = cos(pow((x*x+PI/6),5))-sqrt(x*a*a*a)-log(abs((a-1.12*x)/4));
        System.out.println(r);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a+b,2))-cbrt(a+1.5)+a*pow(b,5)-b/log(a*a);
        System.out.println("y="+y);
        }


    private static void step3() {
        double x = 12.1;
        double a;
        for ( a = -5; a < 13; a=a+3.75) {
            double f=exp(a*x)-3.45*a;
            System.out.println("При а=" + a +" f=" + f);
        }

    }
}
