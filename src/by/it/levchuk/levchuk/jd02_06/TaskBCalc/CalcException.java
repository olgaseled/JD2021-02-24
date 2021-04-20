package by.it.levchuk.levchuk.jd02_06.TaskBCalc;
/*crash-noobik
Liauchuk Aliaksandr*/

public class CalcException extends Exception {
    LoggerCalc loggerCalc=LoggerCalc.LOGGING;

    public CalcException() {
        super();
        loggerCalc.log("CalcException",true);
    }

    public CalcException(String message) {
        super("ERROR: " + message);
        loggerCalc.log("ERROR: " + message,true);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
        loggerCalc.log("ERROR: " + message,true);
    }

    public CalcException(Throwable cause) {
        super(cause);
        loggerCalc.log("ERROR: " + cause,true);
    }
}
