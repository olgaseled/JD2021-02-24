package by.it.savchenko.jd01_13;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            String word = scanner.next();

            word = word.replaceAll("[.,;:]", " ");
            if (word.equals("END")) {
                break;
            }
        }
    }
}
