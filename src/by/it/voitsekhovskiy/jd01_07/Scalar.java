package by.it.voitsekhovskiy.jd01_07;

public class Scalar extends Var{
    private final double value;

     Scalar(double value) {
        this.value = value;
    }

     Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

//    Scalar(Scalar otherScalar) {
//    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
