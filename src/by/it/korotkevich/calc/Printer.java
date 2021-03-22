package by.it.korotkevich.calc;

import java.util.Objects;

public class Printer {
    static void print(Var var) {
        if (Objects.nonNull(var)){
            System.out.println(var);
        }
    }
}
