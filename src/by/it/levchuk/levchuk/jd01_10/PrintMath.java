package by.it.levchuk.levchuk.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;



public class PrintMath {
    public static void main(String[] args) {
        printMathMethods();
        printMathFields();
    }

    public static void printMathMethods() {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder contr = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                contr.append("public ");
            } else {
                continue;
            }
            if (Modifier.isPrivate(modifiers)) {
                contr.append("private ");
            }
            if (Modifier.isStatic(modifiers)) {
                contr.append("static ");
            }
            if (Modifier.isProtected(modifiers)) {
                contr.append("protected ");
            }
            Class<?> returnType = method.getReturnType();
            contr
                    .append(returnType.getSimpleName())
                    .append(' ')
                    .append(method.getName())
                    .append('(');
            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimeter = "";
            for (Class<?> parameterType : parameterTypes) {
                contr.append(delimeter).append(parameterType.getSimpleName());
                delimeter = ",";
            }
            contr.append(")");
            System.out.println(contr);
        }
    }

    public static void printMathFields() {
        Class<Math> mathClass = Math.class;
        Field[] fields = mathClass.getDeclaredFields();
        for (Field field : fields) {
            StringBuilder contr = new StringBuilder();
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                contr.append("public ");
            } else {
                continue;
            }
            if (Modifier.isPrivate(modifiers)) {
                contr.append("private ");
            }
            if (Modifier.isStatic(modifiers)) {
                contr.append("static ");
            }
            if (Modifier.isProtected(modifiers)) {
                contr.append("protected ");
            }
            contr
                    .append(field.getType())
                    .append(' ')
                    .append(field.getName());
            System.out.println(contr);
        }
    }
}