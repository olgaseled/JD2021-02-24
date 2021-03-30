package by.it.dudko.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {

            System.out.print(getExceptionDetails(TaskA.class, e));
        }

    }

    public static String getExceptionDetails(Class<?> runner, Exception e) {
        String exceptionClass = e.getClass().getName();
        String runningClass = runner.getName();
        StackTraceElement traceInfo;
        int lineNumber = -1;
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            if (stackTraceElement.getClassName().equals(runningClass)) {
                lineNumber = stackTraceElement.getLineNumber();
            }
        }
        return  String.format("" +
                " name: %s\n" +
                "class: %s\n" +
                " line: %d", exceptionClass, runningClass, lineNumber);
    }
}
