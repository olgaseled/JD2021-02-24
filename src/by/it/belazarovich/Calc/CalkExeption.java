package by.it.belazarovich.Calc;

public class CalkExeption extends  Exception{
    public CalkExeption(String s, Var var, Var other) {
        super();
    }

    public CalkExeption(String message) {
        super("ERROR: " +message);
    }

    public CalkExeption(String message, Throwable cause) {
        super("ERROR: " +message, cause);
    }

    public CalkExeption(Throwable cause) {
        super("ERROR: " +cause);
    }
}
