package by.it.kirichenko.jd01_05;

import static by.it.kirichenko.jd01_02.TaskC.getRandomInteger;
import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        int lengthArray = getRandomInteger(20, 40);
        double[] arrayA = new double[lengthArray];
        double x = 5.33;
        int countNumberBig3_5 = 0;
        for (int i = 0; i < arrayA.length; i++, x += 0.09) {
            arrayA[i] = cbrt(x * x + 4.5);
            System.out.printf("A[ %-2d] = %1.5f   ", i, arrayA[i]);
            if ((i + 1) % 5 == 0 || i == arrayA.length - 1) {
                System.out.println();
            }
            if (3.5 < arrayA[i]) {
                countNumberBig3_5++;
            }
        }
        double[] arrayB = new double[countNumberBig3_5];
        int j = 0;
        double proizved = 1;
        for (double z : arrayA) {
            if (3.5 < z){
                arrayB[j]=z;
                proizved*=arrayB[j];
                System.out.printf("B[ %-2d] = %1.5f   ", j, arrayB[j]);
                if ((j + 1) % 5 == 0 || j == arrayB.length - 1) {
                    System.out.println();
                }
                j++;
            }
        }
        double sredGeom = pow(proizved,1.0/countNumberBig3_5);
        System.out.printf("Среднее геометрическое = %.4f",sredGeom);
    }
}
