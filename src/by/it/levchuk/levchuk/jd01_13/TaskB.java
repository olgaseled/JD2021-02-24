package by.it.levchuk.levchuk.jd01_13;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Scanner;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);
        double sum = 0.0;

        while (true) {
            String message = data.next();
            if (message.equals("END")) {
                break;
            }
            try {
                double currentNum = Double.parseDouble(message);
                System.out.println(currentNum);
                sum += currentNum;
                if (sum < 0.0) {
                    throw new ArithmeticException();
                }
                double sqrt = sqrt(sum);
                System.out.println(sqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                Class<? extends RuntimeException> exceptionStructure = e.getClass();
                String nameExceptionClass = exceptionStructure.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                Class<TaskB> runnerStructure = TaskB.class;
                String nameRunnerClass = runnerStructure.getName();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    if (className.equals(nameRunnerClass)) {
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf(" name: %s\n" +
                                        "class: %s\n" +
                                        " line: %d",
                                nameExceptionClass, runnerStructure, lineNumber);
                    }
                }
                break;
            }
        }
    }
}
