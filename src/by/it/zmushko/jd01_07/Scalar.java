package by.it.zmushko.jd01_07;

public class Scalar extends Var{

    private final double value;

    public Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public Scalar(double value) {
        this.value = value;
    }

}
