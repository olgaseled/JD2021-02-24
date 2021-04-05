package by.it.dudko.jd01_13;

import java.util.*;

public class TaskC {
    static Scanner scanner;
    static List<Double> numbers;
    static int failureCount;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        numbers = new ArrayList<>();
        readData();
    }

    static void readData() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                // Double inputNumber = scanner.nextDouble();
                String strNum = scanner.nextLine();
                Double inputNumber = Double.parseDouble(strNum);
                numbers.add(inputNumber);
            // } catch (InputMismatchException e) {
            } catch (NumberFormatException e) {
                if (++failureCount == 5) {
                    throw new RuntimeException(e);
                }
                try {
                    //noinspection BusyWait
                    Thread.sleep(100);
                    pintNumbers();
                } catch (InterruptedException | InputMismatchException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

    static void pintNumbers() {
        String delimiter = "";
        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.print(delimiter);
            System.out.print(numbers.get(i));
            delimiter = " ";
        }
        System.out.println();
    }
}
