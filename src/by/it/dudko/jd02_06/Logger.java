package by.it.dudko.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {

    private final File logFile;

    private static volatile Logger loggerInstance;

    private Logger(File logFile) {
        this.logFile = logFile;
    }

    public static Logger getLoggerInstance() {
        Logger localLoggerInstance = loggerInstance;
        if (localLoggerInstance == null) {
            synchronized (Logger.class) {
                localLoggerInstance = loggerInstance;
                if (localLoggerInstance == null) {
                    File logFile = new File(
                            FileNameHelper.getFullPath(
                                    "log.txt",
                                    Logger.class
                            )
                    );
                    localLoggerInstance = new Logger(logFile);
                    loggerInstance = localLoggerInstance;
                }
            }
        }
        return localLoggerInstance;
    }


    synchronized void log(String logLine) {
        try (
                PrintWriter logWriter = new PrintWriter(
                        new FileWriter(logFile, true)
                )
        ) {
            logWriter.println(logLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
