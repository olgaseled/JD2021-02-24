package by.it.seledtsova.jd02_06.TaskB;

public class Printer { // создали класс принтер, который все печатает переменную var в консоле с экземплярным методом вар
    void print (Var var) {
        if (var!=null)
            System.out.println(var);
    }
}
// далее будем собирать наше прилодение. Будем создавать класс ConcoleRunner