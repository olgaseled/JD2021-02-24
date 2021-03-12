package by.it.korotkevich.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "Array", 5);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);

    }
}
