package by.it.seledtsova.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {

// лекция 10 слайд 15
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        Object o = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class))
            {
                if (o == null) {
                    o = beanClass.getDeclaredConstructor().newInstance();

                }
                Param param = method.getAnnotation(Param.class);
                Object invoke = method.invoke(o, param.a(), param.b());
                System.out.println(method.getName()+" "+invoke);

            }

        }
    }
}