package by.it.kaminskii.jd02_06;/* created by Kaminskii Ivan
 */

public class CalcExeption extends Exception {
    public CalcExeption() {
    }

    public CalcExeption(String message) {
        super("ERROR:" + message);
        Logger.getLogger().log("ERROR:"+ message);
    }

    public CalcExeption(String message, Throwable cause) {
        super("ERROR:" + message, cause);
        Logger.getLogger().log("ERROR:"+message+cause);
    }

    public CalcExeption(Throwable cause) {
        super(cause);
    }

    public CalcExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR:" + message, cause, enableSuppression, writableStackTrace);
        Logger.getLogger().log("ERROR:"+ message+cause+enableSuppression+writableStackTrace);
    }
}
