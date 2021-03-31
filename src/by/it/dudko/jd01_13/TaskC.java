package by.it.dudko.jd01_13;

import java.util.*;

public class TaskC {
    static Scanner scanner;
    static List<Double> numbers;
    static int failureCount;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        numbers = new ArrayList<>();

        try {
            readData();
        } catch (BadInputQuotaExceededException e) {
            throw new RuntimeException(e);
        }
    }

    static void readData() throws BadInputQuotaExceededException {
        while (true) {
            try {
                Double inputNumber = scanner.nextDouble();
                numbers.add(inputNumber);
            } catch (InputMismatchException e) {
                if (++failureCount == 5) {
                    throw new BadInputQuotaExceededException("You've broken the scanner");
                }
                try {
                    Thread.sleep(100);
                    pintNumbers();
                } catch (InterruptedException interruptedException) {
                    throw new RuntimeException(interruptedException);
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

    private static class BadInputQuotaExceededException extends Exception {
        public BadInputQuotaExceededException() {
        }

        public BadInputQuotaExceededException(String message) {
            super(message);
        }

        public BadInputQuotaExceededException(String message, Throwable cause) {
            super(message, cause);
        }

        public BadInputQuotaExceededException(Throwable cause) {
            super(cause);
        }
    }
}
