package by.it.korotkevich.jd01_09;

import java.util.Objects;

public class Printer {
    static void print(Var var) {
        if (Objects.nonNull(var)){
            System.out.println(var);
        }
    }
}
