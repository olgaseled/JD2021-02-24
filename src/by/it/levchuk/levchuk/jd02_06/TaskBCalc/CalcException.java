package by.it.levchuk.levchuk.jd02_06.TaskBCalc;
/*crash-noobik
Liauchuk Aliaksandr*/

public class CalcException extends Exception {
    LoggerCalc loggerCalc=LoggerCalc.LOGGING;

    public CalcException() {
        super();
        LoggerCalc.LOGGING.log("CalcException");
    }

    public CalcException(String message) {
        super("ERROR: " + message);
        LoggerCalc.LOGGING.log("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
        LoggerCalc.LOGGING.log("ERROR: " + message);
    }

    public CalcException(Throwable cause) {
        super(cause);
        LoggerCalc.LOGGING.log("ERROR: " + cause);
    }
}
