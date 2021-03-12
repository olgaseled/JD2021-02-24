package by.it.seledtsova.jd01_07;

public class Scalar extends Var{
    private  final double value;

    public Scalar(double value) {
        this.value = value;

    }

    public Scalar(String strValue) {
        this.value=Double.parseDouble(strValue);
    }

   Scalar(Scalar otherScalar) {
        this.value=otherScalar.value;

    }
}
