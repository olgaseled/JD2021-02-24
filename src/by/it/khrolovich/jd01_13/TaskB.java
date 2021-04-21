package by.it.khrolovich.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for (; ; ) {
            String next = scanner.next();
            if (!next.equals("END")) {
                try {
                    double v = Double.parseDouble(next);
                    sum += v;
                    double sqrt = Math.sqrt(sum);
                    if (Double.isNaN(sqrt)) {
                        throw new ArithmeticException();
                    }
                    System.out.println(sqrt);
                } catch (NumberFormatException | ArithmeticException e) {
                    printException(e);
                }
            }
            else break;
        }
    }

    private static void printException(RuntimeException e) {
        Class<? extends RuntimeException> exceptionStructure = e.getClass();
        String nameExceptionClass = exceptionStructure.getName();

        Class<TaskB> runnerStructure = TaskB.class;
        String nameRunnerClass = runnerStructure.getName();


        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            //stackTraceElement.getClass();//это не наш класс, это структура объекта
            String classNameInStackTrace = stackTraceElement.getClassName();
            if (classNameInStackTrace.equals(nameRunnerClass)) {
                int lineNumber = stackTraceElement.getLineNumber();
                System.out.printf("name: %s\nclass: %s\nline: %s\n", nameExceptionClass, classNameInStackTrace, lineNumber);
                break;
            }
        }
    }
}
