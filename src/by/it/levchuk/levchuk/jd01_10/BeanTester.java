package by.it.levchuk.levchuk.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        Object object = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                if (object == null) {
                    object = beanClass.getConstructor().newInstance();
                }
                Param bean = method.getAnnotation(Param.class);
                Object invoke = method.invoke(object, bean.a(), bean.b());
                System.out.println(method.getName() + " " + invoke.toString());
            }
        }
    }
}
