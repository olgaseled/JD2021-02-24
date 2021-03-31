package by.it.voitsekhovskiy.calc;

public class Printer {
    void print(Var variable) {
        System.out.println(variable);
    }

    void print(CalcException e) {
        System.out.println(e);
    }
}
