package by.it.levchuk.levchuk.jd02_06.TaskBCalc;

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
        LoggerCalc.LOGGING.log("ERRORS: " + e.getMessage());
    }
}
