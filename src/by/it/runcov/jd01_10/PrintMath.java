package by.it.runcov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder contract = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                contract.append("public ");
            } else {
                continue;
            }
            if (Modifier.isPrivate(modifiers)) {
                contract.append("private ");
            }
            if (Modifier.isProtected(modifiers)) {
                contract.append("protected ");
            }
            if (Modifier.isStatic(modifiers)) {
                contract.append("static ");
            }
            Class<?> returnType = method.getReturnType();
            contract
                    .append(returnType.getSimpleName())
                    .append(" ")
                    .append(method.getName())
                    .append('(');
            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimiter = "";
            for (Class<?> parameterType : parameterTypes) {
                contract
                        .append(delimiter)
                        .append(parameterType.getSimpleName());
                delimiter = ",";
            }
            contract.append(')');
            System.out.println(contract);
        }

        Field[] fields = mathClass.getDeclaredFields();
        for (Field field : fields) {
            StringBuilder contract = new StringBuilder();
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                contract.append("private ");
            } else {
                continue;
            }
            if (Modifier.isPrivate(modifiers)) {
                contract.append("private ");
            }
            if (Modifier.isProtected(modifiers)) {
                contract.append("protected ");
            }
            if (Modifier.isStatic(modifiers)) {
                contract.append("static ");
            }
            contract
                    .append(field.getType())
                    .append(" ")
                    .append(field.getName());
            System.out.println(contract);
        }
    }
}
