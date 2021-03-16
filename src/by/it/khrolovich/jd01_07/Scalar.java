package by.it.khrolovich.jd01_07;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String s) {
        this.value = Double.parseDouble(s);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}






