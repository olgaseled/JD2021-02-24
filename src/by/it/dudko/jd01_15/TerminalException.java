package by.it.dudko.jd01_15;

public class TerminalException extends Exception {
    public TerminalException() {
        super();
    }

    public TerminalException(String message) {
        super(message);
    }

    public TerminalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TerminalException(Throwable cause) {
        super(cause);
    }
}
