package by.it.zmushko.calculator;

import java.util.Objects;

class Printer {
    void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
        }
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
    }
}
