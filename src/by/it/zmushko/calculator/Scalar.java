package by.it.zmushko.calculator;

public class Scalar extends Var {

    public double getValue() {
        return value;
    }

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value * ((Scalar) other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value - ((Scalar) other).value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondOperator = ((Scalar) other).value;
            if (secondOperator==0){
                throw new CalcException("division by zero");
            }
            return new Scalar(this.value / ((Scalar) other).value);
        }
        return other.div(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
