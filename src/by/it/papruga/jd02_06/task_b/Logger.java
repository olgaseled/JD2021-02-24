package by.it.papruga.jd02_06.task_b;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger {

    LOGGER;

    private final String logName = "log.txt";

    static Logger getLogger(){

        return LOGGER;
    }

    void log(String message){

        try (
            PrintWriter writer = new PrintWriter(new FileWriter(dir(), true));
        ){
            writer.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private synchronized String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = Logger.class.getName()
                .replace(Logger.class.getSimpleName(), "")
                .replace(".", File.separator);
        return path + clDir + logName;
    }

}
