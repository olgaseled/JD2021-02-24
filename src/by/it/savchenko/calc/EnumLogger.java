package by.it.savchenko.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum EnumLogger {
    INSTANCE;
    File logFile;


    public void setFile (File logFile){
        this.logFile=logFile;
    }

    synchronized void log(String logText) {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true)))
        {
            logWriter.println(logText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
