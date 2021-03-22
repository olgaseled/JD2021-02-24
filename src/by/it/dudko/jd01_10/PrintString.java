package by.it.dudko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    void printClassOwnInstanceMethods(Class<?> cls) {
        for (Method method : cls.getDeclaredMethods()) {
            int modifier = method.getModifiers();
            if (Modifier.isStatic(modifier)) {
                continue;
            }
            System.out.println(method.getName());
        }
    }

    public static void main(String[] args) {
        new PrintString().printClassOwnInstanceMethods(java.lang.String.class);
    }
}
