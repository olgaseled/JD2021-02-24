package by.it.seledtsova.jd01_07;

public class Scalar extends Var {  // мы создали двух потомков и он наследуется от класca var

    private final double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}