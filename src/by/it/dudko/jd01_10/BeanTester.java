package by.it.dudko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;

public class BeanTester {


    public static void main(String[] args) throws Exception {
        Class<Bean> bean = Bean.class;
        Class<Param> param = Param.class;
        Object invokeObject = null;
        StringBuilder output = new StringBuilder();
        for (Method method : bean.getDeclaredMethods()) {
            try {
                if (!method.isAnnotationPresent(param)) {
                    throw new Exception();
                }
                output.delete(0,output.length());
                Param annotation = method.getAnnotation(param);
                if (Objects.isNull(invokeObject)) {
                    invokeObject = bean.getDeclaredConstructor().newInstance();
                }
                output.append(String.format("%s ", method.getName()));
                if (Modifier.isStatic(method.getModifiers())) {
                    output.append(method.invoke(null, annotation.a(), annotation.b()));
                } else {
                    output.append(method.invoke(invokeObject, annotation.a(), annotation.b()));
                }
                output.append('\n');
                System.out.print(output);
            } catch (Exception ignored) {

            }
        }
    }
}
