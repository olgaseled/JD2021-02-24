package by.it.dudko.jd02_06.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum LoggerEnum {
    INSTANCE;

    private File logFile;

    public void setLogFile(File logFile) {
        this.logFile = logFile;
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
