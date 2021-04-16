package by.it.dudko.jd02_04;

import java.util.Objects;

class Printer {
    void print(Var result) {
        if (Objects.nonNull(result)) {
            System.out.println(result);
        }
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
    }

}
