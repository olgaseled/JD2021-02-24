package by.it.dudko.jd01_08;

public class Scalar extends Var {

    private final double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Scalar other) {
        return super.add(other);
    }
}
