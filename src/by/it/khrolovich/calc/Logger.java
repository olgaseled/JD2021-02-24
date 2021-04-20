package by.it.khrolovich.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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

        Language lang = Language.INSTANCE;
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, lang.getLocale());
        //DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss",lang.getLocale());
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {

            printWriter.println(df.format(new Date())+": "+message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}