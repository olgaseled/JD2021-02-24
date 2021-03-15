package by.it.baranov.jd01_05;

import java.util.Arrays;
import java.util.Scanner;

public class test {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] strings = scanner.nextLine().split(" ");
    int[] intArray = new int[strings.length];
    for (int i = 0; i < intArray.length; i++) {
        if(Character.isDigit(strings[i].charAt(strings[i].length() - 1)))
            intArray[i] = Integer.parseInt(strings[i]);
    }
    System.out.println(Arrays.toString(intArray));
}}
