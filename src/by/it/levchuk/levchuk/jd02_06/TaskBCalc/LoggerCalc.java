package by.it.levchuk.levchuk.jd02_06.TaskBCalc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum LoggerCalc {LOGGING;

    File logFile;
    public void setLogFile(File logFile) {
        this.logFile = logFile;
    }

    synchronized void log(String logLine) {
        try (
                PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true))) {
            logWriter.println(logLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}