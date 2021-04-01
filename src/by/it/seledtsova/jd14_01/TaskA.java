package by.it.seledtsova.jd14_01;
/*
В классе TaskAнужно выполнить следующие шаги:
Записать в двоичный файл dataTaskA.bin20 случайных чисел типа Integer.
Файл должен быть в том же каталоге, что и исходный код для класса TaskA.java.
Затем нужно прочитать записанный файл в коллекцию ArrayList.
Вывести в консоль прочитанные числа через пробел
Вывести с новой строки их среднее арифметическоеavg=20.123.
Продублировать вывод в консоль в файл resultTaskA.txt
 */
import java.io.*;

public class TaskA {


    private static String dir (Class<?> cl) { // метод определяет текущую директорию, в кот находится наш класс
                                            //FILE.separator - это универсальный разделитесь
     String path=System.getProperty("user.dir")+File.separator+"src"+File.separator; // определяю ПУТЬ , где находится каталог SRC
     String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
                                            //узнаю полный путь к классу. TaskA сотрется, а "." заменится "\"
     return  path+clDir; // возвращаем путь и инфу из клааса
    } //

    public static void main(String[] args) {
        DataOutputStream dos=null;
        try {
            dos=new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream(
                            dir(TaskA.class)+"dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random()*25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (dos !=null) {
                try {
                    dos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try (DataInputStream inp=new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")));
             PrintWriter out2=new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt"))
        ) {
            double sum=0;
            double count=0;
            while (inp.available()>0) {
                int i=inp.readInt();
                System.out.print(i+" ");
                out2.print(i+" ");
                sum=sum+i;
                count++;
            }
            System.out.println("\navg="+sum/count);
            out2.print("\navg="+sum/count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }



























