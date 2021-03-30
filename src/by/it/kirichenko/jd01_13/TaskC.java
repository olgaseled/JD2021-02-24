package by.it.kirichenko.jd01_13;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    static String inputNumber = "";
    static List<Double> listInputNumbers = new LinkedList<>();
    static Exception exception;
    static int countErrors = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            inputNumber = scanner.next();
            if (inputNumber.equals("END")) {
                break;
            }
            readData();
        }
    }

    private static void ifCatch() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = listInputNumbers.size() - 1; 0 <= i; i--) {
            System.out.printf("%s ", listInputNumbers.get(i));
        }
        System.out.println();
        countErrors++;

        if (5 <= countErrors) {
            throw new RuntimeException(exception);
        }
    }

    static void readData() {
        Double number = 0.0;
        try {
            number = Double.parseDouble(inputNumber);
            listInputNumbers.add(number);
        } catch (NumberFormatException e) {
            ifCatch();
        }

    }
}
