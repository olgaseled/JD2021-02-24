package by.it.seledtsova.jd01_14;

import java.io.File;

/*
В классе Task Bнужно выполнить следующие шаги:
        В файле с текстом TaskB.txt нужно подсчитать общее количество знаков препинания и слов
        Вывести результат на консоль в виде одной строки:words=123, punctuation marks=15
        Продублировать вывод в консоль в файл resultTaskB.txt
 */
public class TaskB {



    private static String dir (Class<?> cl) {
        String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator; // определяю ПУТЬ , где находится каталог SRC
        String clDir=path+"jd14_01";
        //узнаю полный путь к классу. TaskB сотрется, а "." заменится "\"
        return  path+clDir; // возвращаем путь и инфу из клааса
    }

    public static void main(String[] args) {

    }

}
