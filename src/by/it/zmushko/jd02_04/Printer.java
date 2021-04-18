package by.it.zmushko.jd02_04;

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
