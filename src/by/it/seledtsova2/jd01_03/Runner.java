package by.it.seledtsova2.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //   String line="71 12 14 789 565 76 712";
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "OurArray", 3);
        Helper.findMin (array);
        Helper.findMax (array);
        Helper.sort (array);

    }



}
