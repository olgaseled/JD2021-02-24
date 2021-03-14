package by.it.maksimova.jd01_07;

public class Scalar extends  Var {

    private final double value;
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
