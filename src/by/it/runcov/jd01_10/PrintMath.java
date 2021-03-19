package by.it.runcov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder contract = new StringBuilder();
            System.out.println(method);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                contract.append("public");
            } else {
                continue;
            }
            if (Modifier.isPrivate(modifiers)) {
                contract.append("private");
            }
            if (Modifier.isProtected(modifiers)) {
                contract.append("protected");
            }
            if (Modifier.isStatic(modifiers)) {
                contract.append("static");
            }
            Class<?> returnType = method.getReturnType();
            contract
                    .append(returnType.getSimpleName())
                    .append(method.getName())
                    .append('(');
            Class<?>[] parameterTypes = method.getParameterTypes();
        }
    }
}
