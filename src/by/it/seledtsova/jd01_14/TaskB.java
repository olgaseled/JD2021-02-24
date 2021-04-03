package by.it.seledtsova.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class TaskB {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator; // определяю ПУТЬ , где находится каталог SRC
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        //узнаю полный путь к классу. TaskB сотрется, а "." заменится "\"
        return path + clDir; // возвращаем путь и инфу из клааса
    }

    public static void main(String[] args) {

        BufferedReader bufferedReader=null; // создали пустое значение

        try {
            bufferedReader= new BufferedReader( // читаем
                    new FileReader(
                            dir(TaskB.class) + "Poem.txt"));

                PrintWriter printWriter = new PrintWriter( // записываем
                        new FileWriter(
                                dir(TaskB.class) + "resultTaskB.txt"));

                int sumPunctuationMark = 0; // сумма знаков препинания
                int sumWord = 0; // количество прочитанных слов

                String line = bufferedReader.readLine();

        while(line !=null)

                {
                    Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find())
                        sumWord++;
                    Pattern pattern1 = Pattern.compile("[.,?!]+");
                    Matcher matcher1 = pattern1.matcher(line);
                    while (matcher1.find())
                        sumPunctuationMark++;
                    System.out.println(line+sumPunctuationMark);
                }
                System.out.println(sumWord);
                System.out.println(sumPunctuationMark);
                printWriter.print(sumWord);
                printWriter.print(sumPunctuationMark);
                // System.out.println("words="+sumWord+", "+"punctuation marks="+sumPunctuationMark);

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








