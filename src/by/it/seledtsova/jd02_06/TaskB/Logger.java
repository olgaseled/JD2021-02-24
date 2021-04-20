package by.it.seledtsova.jd02_06.TaskB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger {
    INSTANCE;

    private  File loggerFile;

    public void setLoggerFile(File loggerFile) {
        this.loggerFile = loggerFile;
    }

    synchronized void log(String loggerLine) {
           try (
                    PrintWriter printWriter = new PrintWriter(new FileWriter(loggerFile, true)) // чем будем писать в файл (append true,чтобы НЕ переписывалось , а записывалось
            ) {
                printWriter.println(loggerLine);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }












