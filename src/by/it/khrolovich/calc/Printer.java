package by.it.khrolovich.calc;

import java.util.Objects;

public class Printer {
    void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
        }
    }

    void printCalcException(Exception e) {
        System.out.println(e.getMessage());
    }
}
