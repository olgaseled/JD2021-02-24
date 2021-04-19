package by.it.kaminskii.jd02_06;/* created by Kaminskii Ivan
 */

class Logger {
    private static volatile Logger logger;

    private Logger() {
    }

    static Logger getLogger() {
        Logger local = logger;
        if (local == null) {
            synchronized (Logger.class) {
                local = logger;
                if (local == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    void log(String massage) {

    }
}
