package by.it.khrolovich.jd01_10;

import by.it._examples_.jd01_10.sample_service.Service;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        Object o = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                if (o == null) {
                    o = beanClass.getDeclaredConstructor().newInstance();
                }
                Param ann = method.getAnnotation(Param.class);
                Object invoke = method.invoke(o, ann.a(), ann.b());

                System.out.println(method.getName() + " " + invoke.toString());
            }

        }
    }
}