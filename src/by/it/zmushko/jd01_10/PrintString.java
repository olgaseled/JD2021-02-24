package by.it.zmushko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] declaredMethods = stringClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            StringBuilder getString = new StringBuilder();
            int modifiers = declaredMethod.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                getString.append(declaredMethod.getName()).append(" ");
                System.out.println(getString);
            }
        }

    }
}
