package by.it.kirichenko.calc;

import java.util.Objects;

public class Printer {
    void print(Var var){
        if (Objects.nonNull(var)){
            System.out.println(var);
            new ThreadLogger(var.toString()).start();
        }
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
        System.err.println(e.getMessage());
        new ThreadLogger(e.getMessage()).start();
    }
}
