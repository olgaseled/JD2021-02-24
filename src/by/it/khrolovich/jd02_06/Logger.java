package by.it.khrolovich.jd02_06;

public class Logger {

    private volatile Logger logger;

    //нельзя будет создать извне
    private Logger() {

    }

    Logger get(){
        Logger localLogger = logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = logger;
                if (localLogger == null) {
                    localLogger = new Logger();
                    logger = localLogger;
                }
            }
        }
        return logger;
    }

    //объкт один - this
    synchronized void log () {
        String filePath = FileNameHelper.getFilePath("log.txt", Logger.class);

    }
}