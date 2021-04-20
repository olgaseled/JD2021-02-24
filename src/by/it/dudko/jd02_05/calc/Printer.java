package by.it.dudko.jd02_05.calc;

import java.util.Objects;

class Printer {
    void print(Var result) {
        if (Objects.nonNull(result)) {
            System.out.println(result);
            print(String.valueOf(result));
        }
    }

    void print(String line) {
        LoggerEnum.INSTANCE.log(line);
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
        LoggerEnum.INSTANCE.log(e.getMessage());
    }

}
