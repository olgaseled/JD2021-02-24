package by.it.khrolovich.calc;

@SuppressWarnings("unused")
public class CalcException extends  Exception{
    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(Language.INSTANCE.get(Message.ERROR)+": "+message);
    }

    public CalcException(String message, Throwable cause) {
        super(Language.INSTANCE.get(Message.ERROR)+": "+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
