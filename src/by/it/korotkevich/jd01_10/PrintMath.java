package by.it.korotkevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {
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
            if (Modifier.isStatic(modifiers)) {
                contract.append("static ");
            }
            if (Modifier.isProtected(modifiers)) {
                contract.append("protected ");
            }
            Class<?> returnType = method.getReturnType();
            contract
                    .append(returnType.getSimpleName())
                    .append(' ')
                    .append(method.getName())
                    .append('(');
            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimeter = "";
            for (Class<?> parameterType : parameterTypes) {
                contract.append(delimeter).append(parameterType.getSimpleName());
                delimeter = ",";
            }
            contract.append(")");
            System.out.println(contract);
            //TODO доделать поля (double E, double PI и т.д.)
        }
    }
}
