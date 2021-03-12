package by.it.papruga.jd01_05;
import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();

    }


    private static void step1() {



            for (double a = 0; a <= 2; a=a+0.2) {
                double sum = 0;
                for (double x = 1; x < 7 ; x++) {

                double y = pow(7,a) - cos(x);
                sum = sum +y;

            }
            System.out.printf("При a =%.2f сумма y=%f\n", a, sum);


        }

    }

    private static void step2() {
    }

}
