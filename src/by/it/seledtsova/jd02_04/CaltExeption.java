package by.it.seledtsova.jd02_04;

public class CaltExeption extends Exception { // унаследуемся от

    public CaltExeption() {
        super();
    }

    public CaltExeption(String message) {
        super("ERROR:"+message);
    }

    public CaltExeption(String message, Throwable cause) {
        super("ERROR:"+message, cause);
    }

    public CaltExeption(Throwable cause) {
        super(cause);
    }



}
