package by.it.seledtsova.jd01_03;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        double [] array=InOut.getArray (str);
        InOut.printArray(array);
        InOut.printArray(array, "V",3);
        Helper.findMax(array);
        Helper.findMin(array);
        double arrayOur[] = new double[]{1, 5, 87, 36, 2};
        System.out.println(Helper.findMin(arrayOur));
        System.out.println(Helper.findMax(arrayOur));
        Helper.sort(arrayOur);
        for (double element : arrayOur) {
            System.out.println(element + " ");
        }
    }
    }

