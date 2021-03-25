package by.it.maksimova.calculator;

import java.util.Objects;

public class Printer {
    void print (Var var) {
        if (Objects.nonNull(var)){
            System.out.println(var);
        }
    }
}
