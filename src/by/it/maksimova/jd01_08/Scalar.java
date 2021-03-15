package by.it.maksimova.jd01_08;

import java.util.Scanner;

public class Scalar extends Var {

    private final double value;

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar)other).value;
            double result = this.value + otherValue;
            return new Scalar(result);
        }
        return other.add(this);
    }

    // первый конструктор - возвращать строку из вещественного числа
     Scalar(double value) {
        this.value = value;
    }
// второй конструктор из строки вида 3.1415 в double
     Scalar(String strValue) {
        this.value=Double.parseDouble(strValue);
    }
// из точно такой же переменной
     Scalar(Scalar otherScalar) {
        this.value= otherScalar.value;
    }
// переопредление метода String toString() из Object
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
