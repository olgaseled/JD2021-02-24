package by.it.savchenko.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        Object obj = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                if (obj == null) {
                    obj = beanClass.getDeclaredConstructor().newInstance();
                }
                    Param param = method.getAnnotation(Param.class);
                    Object invoke = method.invoke(obj, param.a(), param.b());
                    System.out.println(method.getName() + " " + invoke);
                }
            }
        }
    }
