package by.it.levchuk.levchuk.jd01_13;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {


            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            Class<? extends RuntimeException> exceptionStructure = e.getClass();
            String nameExceptionClass = exceptionStructure.getName();
            System.out.println(nameExceptionClass);
            Class<TaskA> runnerStructure = TaskA.class;
            String nameRunnerClass=runnerStructure.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement: stackTrace){
                String classNameInStackTrase=stackTraceElement.getClassName();
            }
        }
    }
}
