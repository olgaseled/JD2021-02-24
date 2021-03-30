package by.it.kirichenko.jd01_13;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> listDouble = new LinkedList<>();
        double currentNumber = 0.0;
        double sum = 0.0;
        Double sqrt = 0.0;
        while (true) {
            String word = scanner.next();
            if (word.equals("END")) {
                break;
            }
            try {

                currentNumber = Double.parseDouble(word);
                listDouble.add(currentNumber);
                System.out.println(listDouble.get(listDouble.size() - 1).toString());

                sum += currentNumber;
                sqrt=Math.pow(sum, 0.5);
                if (sqrt.isNaN()){
                    throw new ArithmeticException();
                }
                System.out.println(sqrt);
            } catch (NumberFormatException | ArithmeticException e) {
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

        }
    }
}
