package by.it.zmushko.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception { //переделать ещё
        Class<Bean> cls = Bean.class;
        Object obj = null;
        Method[] methods = cls.getDeclaredMethods();
        Class<Param> parameters = Param.class;
        for (Method method : methods) {
            if (method.isAnnotationPresent(parameters)) {
                    if (obj == null) {
                        obj = cls.getDeclaredConstructor().newInstance();
                    }
                    Param annotation = method.getAnnotation(Param.class);
                    Object invoker = method.invoke(obj, annotation.a(), annotation.b());
                    System.out.printf("%s, %s \n", method.getName(), invoker);
            }
        }


    }


}

