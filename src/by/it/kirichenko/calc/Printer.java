package by.it.kirichenko.calc;

import java.util.Objects;

public class Printer {
    void print(Var var){
        if (Objects.nonNull(var)){
            System.out.println(var);
        }
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
        System.err.println(e.getMessage());
    }
}
