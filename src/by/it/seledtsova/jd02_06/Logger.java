package by.it.seledtsova.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private static volatile Logger logger; // приватное поле. volatile гаран-ет , что чтение или запись потокобезопасна

    private Logger() {    // приватный конструктор
    }


    private final String logName = "log.txt"; // создадим имя файла, чтобы getPath () нам его вернул
// static жестко все вшито. без static  чистое ОПП

    static Logger getLogger() { //  сиглтон. static метод для получ экземпляра этого поля
        Logger local = logger; //мы сна чала создадим локальны логгер и прочитаем его
        if (local == null) {   // есть он равен null
            synchronized (Logger.class) { // пока мы висели на блокировке логгер мог родится, поэтому
                local = logger; // мы снова читаем логгер и опять его проверяем
                if (local == null) { // если мы логгер прочитали и он еще null
                    local = logger = new Logger(); // то создали логгер, разместили его в volatile поле и сразу его в local
                }
            }
        }
        return local;  // и вернули local, чтобы к полю volatile не обращаться

    }


    void log(String message) { // экземпляр нашего логера пишет какой-то message в лог
        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(getPath(), true)) // чем будем писать в файл (append true,чтобы НЕ переписывалось , а записывалось
        ) {
            printWriter.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("SaveParametrValue") // скопировали мeтод с jd01-15
    private synchronized String getPath() { // многократно из разных потоков обратиться нельзя
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator; // определяю ПУТЬ , где находится каталог SRC
        String clDir = Logger.class.getName().replace(Logger.class.getSimpleName(), "").replace(".", File.separator);
        //узнаю полный путь к классу. TaskA сотрется, а "." заменится "\"
        return path + clDir + logName; // возвращаем путь и инфу из клааса
    }

}
