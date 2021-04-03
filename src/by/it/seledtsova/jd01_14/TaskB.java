package by.it.seledtsova.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
В классе TaskB нужно выполнить следующие шаги:
В файле с текстом TaskB.txt нужно подсчитать общее количество знаков препинания и слов
Вывести результат на консоль в виде одной строки:words=123, punctuation marks=15
Продублировать вывод в консоль в файл resultTaskB.txt
 */


public class TaskB {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator; // определяю ПУТЬ , где находится каталог SRC
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        //узнаю полный путь к классу. TaskB сотрется, а "." заменится "\"
        return path + clDir; // возвращаем путь и инфу из клааса
    }

    public static void main(String[] args) {

        BufferedReader bufferedReader=null; // создали пустое значение
        PrintWriter printWriter=null;
        try {
            bufferedReader= new BufferedReader( // читаем
                    new FileReader(
                            dir(TaskB.class) + "Poem.txt"));

            PrintWriter out2 = new PrintWriter(
                    new FileWriter(
                            dir(TaskB.class) + "resultTaskB.txt"));

                int sumPunctuationMark = 0; // сумма знаков препинания
                int sumWord = 0; // количество прочитанных слов

                String line;

        while((line = bufferedReader.readLine()) !=null)

                {
                    Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find())
                        sumWord++;
                    Pattern pattern1 = Pattern.compile("[.,!?:-]+");
                    Matcher matcher1 = pattern1.matcher(line);
                    while (matcher1.find())
                        sumPunctuationMark++;
                    //System.out.println(line+sumPunctuationMark);
                }
            System.out.println("words="+sumWord+", "+"punctuation marks="+sumPunctuationMark);

            out2.println("words="+sumWord+", punctuation marks="+sumPunctuationMark);



        } catch(IOException e){
                e.printStackTrace(); //
            }

        finally{ // будем закрывать файл
            if (bufferedReader != null) {
                try {

                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace(); //
                }
            }
        }
    }
}








