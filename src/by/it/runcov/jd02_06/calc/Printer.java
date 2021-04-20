package by.it.runcov.jd02_06.calc;

import java.util.Objects;

public class Printer {
    void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
            LoggerCalc.INSTANCE.log(String.valueOf(var));
        }
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
        LoggerCalc.INSTANCE.log(e.getMessage());
    }
}
