package by.it.korotkevich.jd02_06.LoggerENUM;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

enum Logger{
    INSTANCE;
    private final File logFile;

    Logger() {
        logFile = Util.getFile(Logger.class, "log.txt");
    }

    synchronized void log(String logText) {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true))) {
            logWriter.println(logText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}