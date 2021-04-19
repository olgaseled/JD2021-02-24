package by.it._classwork_.jd02_06;

import java.io.*;

class Logger {

    private final File logFile;

    private static volatile Logger logger;

    private Logger() {
        logFile = Util.getFile(Logger.class, "log.txt");
    }

    public static Logger getLogger() {
        Logger local = logger;
        if (local == null) {
            synchronized (Logger.class) {
                local = logger;
                if (local == null) {
                    local = new Logger();
                    logger = local;
                }
            }
        }
        return local;
    }


    synchronized void log(String logText) {
        try (
                PrintWriter logWriter = new PrintWriter(
                        new FileWriter(logFile, true)
                )
        ) {
            logWriter.println(logText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
