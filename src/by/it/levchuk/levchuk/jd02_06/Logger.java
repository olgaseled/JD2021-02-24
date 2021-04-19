package by.it.levchuk.levchuk.jd02_06;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private final File logFile;
    private static volatile Logger instanceLogger;

    private Logger() {
        logFile = Util.getFile(Logger.class, "LogList.txt");
    }

    public static Logger getInstanceLogger() {
        Logger localLogger = instanceLogger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = instanceLogger;
                if (localLogger == null) {
                    localLogger = new Logger();
                    instanceLogger = localLogger;
                }
            }
        }
        return localLogger;
    }

    synchronized void log(String logText) {
        try (
                PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true))
        ) {
            logWriter.println(logText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
