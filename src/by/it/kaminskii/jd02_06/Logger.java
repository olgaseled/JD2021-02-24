package by.it.kaminskii.jd02_06;/* created by Kaminskii Ivan
 */

import java.io.*;

enum Logger {
    INSTANCE;

    FindPath findPath = new FindPath();

    Serializable getPathLogger() {
        return findPath.getFilePath(Logger.class, "log.txt");
    }

    static Logger getLogger() {
        return INSTANCE;
    }

    void log(String massage) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter((File) getPathLogger(), true))) {
            printWriter.println(massage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
