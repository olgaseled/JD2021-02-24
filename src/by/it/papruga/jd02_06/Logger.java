package by.it.papruga.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private static volatile Logger logger;

    private final String logName = "log.txt";

    private Logger(){
    }

    static Logger getLogger(){

        Logger local = logger;

        if (local==null){
            synchronized (Logger.class){
                local = logger;
                if (local == null){
                    local = logger = new Logger();
                }
            }
        }
        return local;

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
