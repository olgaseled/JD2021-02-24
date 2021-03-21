package by.it.seledtsova.jd01_10;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) //  аннотация применяется в момент работы программы
@Target(ElementType.METHOD) // указали на что распространяется аннотация
public @interface Param {
    int a(); // параменты аннотации указываются также как и методы. если а имеет например зачение, то int a () default 100
    int b();

}
  //  TaskA1.Создайте собственную аннотацию Param, которая описывает параметры для некоторой
  //  процедуры тестирования произвольного методас сигнатурой (int a, int b),
//  помеченного такой аннотацией.Пример использования:@Param(a=2, b=5)public double avg(int a, int b) { … }.
