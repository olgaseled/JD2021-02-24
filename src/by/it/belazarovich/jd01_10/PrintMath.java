package by.it.belazarovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] metods = structMath.getDeclaredMethods();
        for (Method metod : metods) {
            if ((metod.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                System.out.println(metod);
            }
        }
    }
}
