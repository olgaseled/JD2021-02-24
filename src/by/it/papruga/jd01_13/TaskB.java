package by.it.papruga.jd01_13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> lines = new ArrayList<>();

        try {
            while (true) {
                String line = scanner.nextLine();
                if (!line.equals("END")) {
                    lines.add(Double.parseDouble(line));
                    Iterator<Double> iterator = lines.iterator();
                    double sum = 0;
                    while (iterator.hasNext()) {
                        Double element = iterator.next();
                        sum = sum + element;
                    }

                    if (sum <= 0)
                        throw new ArithmeticException();

                    System.out.println(Math.sqrt(sum));
                } else break;
            }

        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {

                if (TaskB.class.getName().equals(element.getClassName())) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int lineNumber = element.getLineNumber();
                    System.out.printf(" name: %s\n" +
                                    "class: %s\n" +
                                    " line: %d",
                            name, className, lineNumber);
                    break;
                }
            }
        }
    }
}
















