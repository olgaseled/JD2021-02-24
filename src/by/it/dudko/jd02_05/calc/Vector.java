package by.it.dudko.jd02_05.calc;

import java.util.Arrays;



public class Vector extends Var {

    private final double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this(vector.value);
    }

    public Vector(String strVector) {
        this.value = Utils.castAsVectorOfDoubles(strVector);
    }


    @Override
    public String toString() {
        return Utils.stringifyArray(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double addendum = ((Scalar) other).getValue();
            double[] sum = new double[this.getValue().length];
            for (int i = 0; i < sum.length; i++) {
                sum[i] = this.value[i] + addendum;
            }
            return new Vector(sum);
        }
        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).getValue();
            if (secondVector.length != this.getValue().length) {
                throw new CalcException(Language.INSTANCE.get(
                        Messages.INCOMPATIBLE_VECTORS));
            }
            double[] sum = new double[secondVector.length];
            for (int i = 0; i < sum.length; i++) {
                sum[i] = this.value[i] + secondVector[i];
            }
            return new Vector(sum);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return this.add(other.mul(new Scalar(-1)));
        }
        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).getValue();
            if (secondVector.length != this.getValue().length) {
                throw new CalcException(Language.INSTANCE.get(Messages.INCOMPATIBLE_VECTORS));
            }
            double[] subtraction = new double[secondVector.length];
            for (int i = 0; i < subtraction.length; i++) {
                subtraction[i] = this.value[i] - secondVector[i];
            }
            return new Vector(subtraction);
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double multiplier = ((Scalar) other).getValue();
            double[] multiplication = new double[this.getValue().length];
            for (int i = 0; i < multiplication.length; i++) {
                multiplication[i] = this.value[i] * multiplier;
            }
            return new Vector(multiplication);
        }
        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).getValue();
            if (secondVector.length != this.getValue().length) {
                throw new CalcException(Language.INSTANCE.get(Messages.INCOMPATIBLE_VECTORS));
            }
            double multiplication = 0;
            for (int i = 0; i < secondVector.length; i++) {
                multiplication += this.value[i] * secondVector[i];
            }
            return new Scalar(multiplication);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double divisor = ((Scalar) other).getValue();
            double[] quotient = new double[this.getValue().length];
            for (int i = 0; i < quotient.length; i++) {
                quotient[i] = this.value[i] / divisor;
            }
            return new Vector(quotient);
        }
        return super.div(other);
    }
}
