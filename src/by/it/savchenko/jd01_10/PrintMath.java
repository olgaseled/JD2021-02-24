package by.it.savchenko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {


        Class<Math> strathMath = Math.class;
        Method[] methods = strathMath.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PRIVATE) != Modifier.PRIVATE)
                System.out.println(method);


        }
    }

    public static float abs(float a) {
        Class<Math> strathMath = Math.class;
        Method[] methods1 = strathMath.getDeclaredMethods();
        for (Method method : methods1) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println(method);
        }
        return a;
    }
}


