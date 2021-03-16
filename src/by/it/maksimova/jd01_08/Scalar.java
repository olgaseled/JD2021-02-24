package by.it.maksimova.jd01_08;

import java.util.Scanner;

public class Scalar extends Var {

    private final double value;

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
          double sum = this.value+((Scalar) other).value;
            return new Scalar(sum);
//            такая же запись ниже
//            return new Scalar(this.value + ((by.it._classwork_.jd01_08.Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value-((Scalar) other).value;
            return new Scalar(sub);
        }
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul = this.value*((Scalar) other).value;
            return new Scalar(mul);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double secondScalar=((Scalar) other).value;
            if (secondScalar==0){
                return null; //TODO div by zero
            }
            return new Scalar(this.value / secondScalar);
        }
        return super.div(other);
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
