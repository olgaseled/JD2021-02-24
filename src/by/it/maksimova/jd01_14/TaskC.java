package by.it.maksimova.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    //классе TaskC нужно выполнить следующие шаги:
    //Вывести список всехфайлов и каталогов вашего пакета by.it.фамилияв формате file:имя_файлаили dir:имя_каталога.
    //Продублировать вывод в консоль в файл resultTaskC.txt
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    public static final String RESULT_TASK_С_TXT = "resultTaskС.txt";
    public static final String BY = "by";
    public static final String IT = "it";
    public static final String MAKSIMOVA = "maksimova";

    private static String dir(Class<?> cl) {
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = TaskB.class.getName().replace(TaskB.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        File file = new File(new File(System.getProperty(USER_DIR)) +
                File.separator + SRC +
                File.separator + BY + File.separator + IT + File.separator + MAKSIMOVA);

        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println("dir: " + item.getName());
                } else
                    System.out.println("file: " + item.getName());

                try (PrintWriter out = new PrintWriter(new FileWriter(dir(TaskC.class) + RESULT_TASK_С_TXT))) {
                    if (item.isDirectory()) {
                        out.println("dir: " + item.getName());
                    } else
                        out.println("file: " + item.getName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    }
}
