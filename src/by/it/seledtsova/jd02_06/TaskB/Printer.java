package by.it.seledtsova.jd02_06.TaskB;

public class Printer { // создали класс принтер, который все печатает переменную var в консоле с экземплярным методом вар
    void print (Var var) {
        if (var!=null)
            System.out.println(var);
        Logger.INSTANCE.log(String.valueOf(var));
    }
    void print (CaltExeption e) {
        System.out.println(e.getMessage());
        Logger.INSTANCE.log(e.getMessage());
    }
    }
// далее будем собирать наше приложение. Будем создавать класс ConcoleRunner