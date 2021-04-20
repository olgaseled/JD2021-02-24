package by.it.khrolovich.calc;

import java.util.Objects;

public class Printer {
    void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
            Logger.get().log(var.toString());
        }
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
        Logger.get().log(e.getMessage());
    }
}
