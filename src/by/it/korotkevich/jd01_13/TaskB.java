package by.it.korotkevich.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        List<Double> elements = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String element = scanner.nextLine();
            double average = 0;
            if (!element.equals("END")) {
                try {
                    elements.add(Double.valueOf(element));
                    for (Double oneElement : elements) {
                        average += oneElement;
                    }
                    System.out.println(element);
                    if (!(average<=0)) {
                        System.out.println(Math.sqrt(average));
                    } else {
                        throw new ArithmeticException();
                    }
                } catch (NumberFormatException | NullPointerException | ArithmeticException e) {
                    Class<? extends RuntimeException> exceptionStructure = e.getClass();
                    String nameExceptionClass = exceptionStructure.getName();
                    Class<TaskB> runnerStructure = TaskB.class;
                    String nameRunnerClass = runnerStructure.getName();
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        String classNameInStackTrace = stackTraceElement.getClassName();
                        if (classNameInStackTrace.equals(nameRunnerClass)) {
                            int lineNumber = stackTraceElement.getLineNumber();
                            System.out.printf("" +
                                            " name: %s\n" +
                                            "class: %s\n" +
                                            " line: %d\n",
                                    nameExceptionClass, classNameInStackTrace, lineNumber);
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
    }
}
