package by.it.khrolovich.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "A", 3);

        double min = Helper.findMin(array);
        System.out.println(min);

        double max = Helper.findMax(array);
        System.out.println(max);

        Helper.sort(array);
        InOut.printArray(array);

        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        double[] vector = {1, 2, 3};
        double[] res = Helper.mul(matrix, vector);
        System.out.println(Arrays.toString(res));

        double[][] matrixLeft = {
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] matrixRight = {{1, 2}, {1, 2}, {1, 2}};
        double[][] resMatrix = Helper.mul(matrixLeft, matrixRight);
        for (double[] v : resMatrix) {
            System.out.println(Arrays.toString(v));
        }
    }
}
