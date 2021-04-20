package by.it.korotkevich.calc;

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

    synchronized void log(String logText, boolean ln) {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true))) {
            if (ln){
                logWriter.println(logText);
            } else {
                logWriter.print(logText);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}