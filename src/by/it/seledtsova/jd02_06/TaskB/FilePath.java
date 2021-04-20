package by.it.seledtsova.jd02_06.TaskB;

import java.io.File;

public class FilePath {

    private FilePath() {
    }


    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";


    @SuppressWarnings("SaveParametrValue") // скопировали мeтод с jd01-15

    public static String getFilePath(String filename, Class<?> currentStructure) { // многократно из разных потоков обратиться нельзя
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator; // определяю ПУТЬ , где находится каталог SRC
        String clDir =Logger.class.getName().replace(Logger.class.getSimpleName(), "").replace(".", File.separator);
        //узнаю полный путь к классу. TaskA сотрется, а "." заменится "\"
        return path + clDir + filename; // возвращаем путь и инфу из клааса
    }



    }



