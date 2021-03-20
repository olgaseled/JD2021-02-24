package by.it.kirichenko.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> structBean = Bean.class;
        //Constructor<?> constructor=structBean.getConstructor();
        //Object beanObject = constructor.newInstance();//structBean.getConstructor(Bean.class).newInstance();
        Object beanObject = structBean.newInstance();
        Method[] methods = structBean.getDeclaredMethods();
        for (Method method : methods) {
            Param annotation = method.getAnnotation(Param.class);
            if (annotation != null) {
                System.out.printf("%s %4.1f\n",method.getName(),method.invoke(beanObject,annotation.a(),annotation.b()));
            }
            //method.getAnnotation(Param.class)
        }
    }
}
