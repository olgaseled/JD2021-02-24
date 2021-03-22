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
                try {
                if (obj == null) {

                        obj = cls.getConstructor().newInstance();
                        method.invoke(obj);
                        System.out.println(method.invoke(obj));
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}

