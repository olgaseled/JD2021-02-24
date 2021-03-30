package by.it.dudko.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    private double sum;

    private final Scanner scanner;

    private final String stopWord = "END";

    public TaskB(Scanner scanner) {
        Locale.setDefault(Locale.ENGLISH);
        this.scanner = scanner;
        sum = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskB hw = new TaskB(sc);
        for (String input = ""; ; ) {
            try {
                input = hw.readInputLine();
                if (input.toUpperCase().equals(hw.stopWord)) break;
                double parsedNumber = hw.toDouble(input);
                hw.summarizer(parsedNumber);
                System.out.printf("%f.2 %f.2\n", parsedNumber, hw.calculateSqrt(hw.getSum()));
            } catch (ArithmeticException | NumberFormatException e) {
                System.out.println(TaskA.getExceptionDetails(TaskB.class, e));
            }
        }
    }

    public String readInputLine() {
        return scanner.nextLine();
    }

    public Double toDouble(String strNum) {
        return Double.parseDouble(strNum);
    }

    public void summarizer(double number) {
        sum = sum + number;
    }

    public Double getSum() {
        return sum;
    }

    public Double calculateSqrt(double value) throws ArithmeticException {
        double result = Math.sqrt(value);
        if (!Double.isNaN(result)) {
            return result;
        } else {
            throw new ArithmeticException("ERROR: Getting square root from negatives is forbidden!");
        }
    }

}
