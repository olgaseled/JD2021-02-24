package by.it.zmushko.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Locale;

public class Logger {

    public static volatile Logger single;

    private final File logFile;

    public Logger() {
        logFile = FindPath.getFilePath("userLog.txt", Logger.class);
    }

    public static Logger getLogger() {
        Logger thisLogger = single;
        if (thisLogger == null) {
            synchronized (Logger.class) {
                thisLogger = single;
                if (thisLogger == null) {
                    thisLogger = new Logger();
                    single = thisLogger;
                }
            }
        }
        return thisLogger;
    }

    synchronized void logging(String logTxt) {
        try (
            PrintWriter logWrite = new PrintWriter(new FileWriter(logFile, true))
        ) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale("EN"));
            logWrite.println(logTxt + " Date: " + df.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
