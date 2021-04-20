package by.it.levchuk.levchuk.jd02_04;

import java.util.Objects;

public class Printer {
    void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
            LoggerCalc.LOGGING.log(String.valueOf(var));
        }
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
        LoggerCalc.LOGGING.log(e.getMessage());
    }
}
