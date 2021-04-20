package by.it.kaminskii.jd02_06;/* created by Kaminskii Ivan
 */

import java.io.*;

enum Logger {
    INSTANCE;

    FindPath findPath=new FindPath();

    private static volatile Logger logger;

    Serializable getPathLogger() {
        File loggerPath = findPath.getFilePath(Logger.class, "log.txt");
        return loggerPath;
    }

    static Logger getLogger() {
        Logger local = logger;
        if (local == null) {
            synchronized (Logger.class) {
                local = logger;
                if (local == null) {
                    local = INSTANCE;
                    logger=local;
                }
            }
        }
        return local;
    }

    void log(String massage) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter((File) getPathLogger(), true))){
            printWriter.println(massage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
