package by.it.korotkevich.calc;

import by.it._examples_.jd01_11.generics.Demo;

class Scalar extends Var {

    private final double value;

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value * ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value - ((Scalar) other).value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherOperand = ((Scalar) other).value;
            if (otherOperand == 0) {
                throw new CalcException("division by zero");
            }
            return new Scalar(this.value / otherOperand);
        }
        return super.div(other);
    }

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


    public double getValue() {
        return value;
    }
}
