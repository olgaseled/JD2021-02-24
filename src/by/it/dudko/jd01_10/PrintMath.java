package by.it.dudko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class PrintMath {

    void printClassOwnPublicMembers(Class<?> cls) {
        StringBuilder output = new StringBuilder();
        for (Method method : cls.getDeclaredMethods()) {
            int modifier = method.getModifiers();
            if (!Modifier.isPublic(modifier)) {
                continue;
            }
            output.append("public ");
            if (Modifier.isStatic(modifier)) {
                output.append("static ");
            }
            output.append(method.getReturnType().getTypeName())
                    .append(" ")
                    .append(method.getName())
                    .append("(");
            String delimiter = "";
            for (Parameter parameter : method.getParameters()) {
                output.append(delimiter).append(parameter.getType().getName());
                delimiter = ",";
            }
            output.append(")\n");
        }

        for (Field field : cls.getDeclaredFields()) {
            int modifier = field.getModifiers();
            if (!Modifier.isPublic(modifier)) {
                continue;
            }
            output.append("public ");
            if (Modifier.isStatic(modifier)) {
                output.append("static ");
            }
            if (Modifier.isFinal(modifier)) {
                output.append("final ");
            }
            output.append(field.getType().getName())
                    .append(" ")
                    .append(field.getName())
                    .append('\n');
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        new PrintMath().printClassOwnPublicMembers(java.lang.Math.class);
    }

}
