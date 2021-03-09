package by.it.zmushko.jd01_05;

import java.util.Random;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        int MIN = 20;
        int MAX = 40;
        int indexElem = 0;
        Random random = new Random();
        double[] array = new double[random.nextInt(MAX - MIN + 1) + MIN];
        double step = (9 - 5.33) / (array.length - 1);
        for (double i = 5.33; i < 10; i += step) {
            array[indexElem] = cbrt(pow(i, 2) + 4.5);
            if (indexElem < array.length - 1) {
                indexElem++;
            }
        }
        System.out.println("Массив А[]");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("A[%3d] = %f    ", i, array[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                count++;
            }
        }
        double[] arrayB = new double[count];
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = i;
            if (array[i] > 3.5) {
                break;
            }
        }

        for (int i = 0; i < arrayB.length - 1; i++) {
            arrayB[i] = array[temp];
            if (temp < array.length - 1) {
                temp++;
            }
        }

        System.out.println("Массив B[]");
        for (int i = 0; i < arrayB.length - 1; i++) {
            System.out.printf("A[%3d] = %f    ", i, arrayB[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

        double result = 1;
        for (int i = 0; i < arrayB.length - 1; i++) {
            result *= arrayB[i];
        }
        result = pow(result, 1.0/arrayB.length);
        System.out.println("\nСреднее геометрическое чисел из массива В = " + result);
    }
}


