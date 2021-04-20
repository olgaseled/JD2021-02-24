package by.it.savchenko.jd02_06;

import java.util.Objects;

public class Printer {
    void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
            EnumLogger.INSTANCE.log(String.valueOf(var));
        }
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
        EnumLogger.INSTANCE.log(e.getMessage());
        //System.err.println(e.getMessage());
    }
}
