package by.it.savchenko.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        double min = Helper.findMin(array);
        double max = Helper.findMax(array);
        Helper.sort(array);

        System.out.println("Минимальное значение: " + min + "Максимальное значение: " + max);
    }
}
