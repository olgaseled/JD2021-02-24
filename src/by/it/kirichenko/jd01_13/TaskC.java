package by.it.kirichenko.jd01_13;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    static String inputNumber = "";
    static List<String> listInputNumers = new LinkedList<>();

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
        for (int i = listInputNumers.size()-1; 0 <= i; i--) {
            System.out.println(listInputNumers.get(i));
        }
    }

    static void readData() {
        listInputNumers.add(inputNumber);
        Double number = 0.0;
        try {
            number = Double.parseDouble(inputNumber);
        } catch (NumberFormatException e) {
            ifCatch();
        }
    }
}
