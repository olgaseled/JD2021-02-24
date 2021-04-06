package by.it.kaminskii.jd01_13;/* created by Kaminskii Ivan
 */

import java.util.Scanner;

public class TaskB {
    static double sum = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String consoleReader;
        try {
            while (!(consoleReader = scanner.next()).equals("END")) {
                double num = Double.parseDouble(consoleReader);
                System.out.println(num);
                sum += num;
                if(sum>0.0)
                System.out.println(Math.sqrt(sum));
                else{
                    throw new ArithmeticException();
                }
            }
            sum = 0.0;
        }
        catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                    String name = e.getClass().getName();
                    String className = stackTraceElement.getClassName();
                    int number = stackTraceElement.getLineNumber();
                    System.out.printf(" name: %s\nclass: %s\n line: %d", name, className, number);
                }
            }
        }
    }
}
