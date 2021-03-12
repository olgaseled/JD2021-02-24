package by.it.papruga.jd01_07;

public class Scalar extends Var {

    private final double value;


    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public String toString() {
        return "Scalar{" +
                "value=" + value +
                '}';
    }
}
