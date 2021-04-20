package by.it.khrolovich.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private static volatile Logger logger;

    //нельзя будет создать извне
    private Logger() {

    }

    static Logger get() {
        Logger localLogger = logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = logger;
                if (localLogger == null) {
                    localLogger = new Logger();
                    logger = localLogger;
                }
            }
        }
        return localLogger;
    }

    //объкт один - this
    synchronized void log(String message) {

        String filePath = FileNameHelper.getFilePath("log.txt", Logger.class);

        try(PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {
            printWriter.println(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}