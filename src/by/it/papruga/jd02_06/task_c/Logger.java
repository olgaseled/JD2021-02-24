package by.it.papruga.jd02_06.task_c;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    public static class LoggerHolder{

        public static final Logger HOLDER_INSTANCE = new Logger();
    }

    private final String logName = "log.txt";

    private Logger(){
    }

    static Logger getLogger(){

        return LoggerHolder.HOLDER_INSTANCE;
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
