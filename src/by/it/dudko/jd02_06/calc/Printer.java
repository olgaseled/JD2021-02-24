package by.it.dudko.jd02_06.calc;

import java.util.Objects;

class Printer {
    void print(Var result) {
        if (Objects.nonNull(result)) {
            System.out.println(result);
            LoggerEnum.INSTANCE.log(String.valueOf(result));
        }
    }

    void print(CalcException e) {
        System.out.println(e.getMessage());
        LoggerEnum.INSTANCE.log(e.getMessage());
    }

}
