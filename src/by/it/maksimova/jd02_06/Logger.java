package by.it.maksimova.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";

    private static volatile Logger logger;

    private final String fileName = "log.txt";

    private Logger() {
    }

    static Logger getLogger() {
        Logger localLogger = logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = logger;
                if (localLogger == null) {
                    localLogger = logger = new Logger();
                }
            }
        }
        return localLogger;
    }


    void log(String message) {
       try ( PrintWriter writer = new PrintWriter(new FileWriter(getPath(), true))){
           writer.println(message);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    private synchronized String getPath() {
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = Logger.class.getName()
                .replace(Logger.class.getSimpleName(), "")
                .replace(".", File.separator);
        return path + clDir + fileName;
    }

}
