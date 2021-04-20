package by.it.korotkevich.calc;

public class CalcException extends Exception {

    Logger logger = Logger.INSTANCE;

    public CalcException() {
        super();
        logger.log("CalcException", true);
    }

    public CalcException(String message) {
        super("ERROR:" + message);
        logger.log("ERROR:" + message, true);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:" + message, cause);
        logger.log("ERROR:" + message, true);
    }

    public CalcException(Throwable cause) {
        super(cause);
        logger.log("ERROR:" + cause, true);
    }
}
