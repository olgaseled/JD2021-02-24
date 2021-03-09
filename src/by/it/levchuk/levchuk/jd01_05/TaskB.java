package by.it.levchuk.levchuk.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        for (double a = 0; a <=2 ; a=a+0.2) {
            double y = pow(7,a)*6-cos(1)-cos(2)-cos(3)-cos(4)-cos(5)-cos(6);
            for (int i = 0; i < 6; ++i) {
                System.out.printf("при а=%-10.3f x=%e \n ", a, y);
                
            }
        }
    }
}
