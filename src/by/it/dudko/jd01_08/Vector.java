package by.it.dudko.jd01_08;

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
        this.value = castAsVectorOfDoubles(strVector);
    }

    private double[] castAsVectorOfDoubles(String strVector) {
        strVector = Utils.trimBraces(strVector);
        String[] strVectorItems = Utils.splitToRowItems(strVector);
        double[] vector = new double[strVectorItems.length];
        for (int i = 0; i < strVectorItems.length; i++) {
            vector[i] = Double.parseDouble(strVectorItems[i]);
        }
        return vector;
    }

    @Override
    public String toString() {
        return Utils.stringifyArray(value);
    }

    @Override
    public Var add(Var other) {
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
                return null; //TODO incompatible vectors
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
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            return this.add(other.mul(new Scalar(-1)));
        }
        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).getValue();
            if (secondVector.length != this.getValue().length) {
                return null; //TODO incompatible vectors
            }
            double[] sum = new double[secondVector.length];
            for (int i = 0; i < sum.length; i++) {
                sum[i] = this.value[i] - secondVector[i];
            }
            return new Vector(sum);
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
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
                return null; //TODO incompatible vectors
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
    public Var div(Var other) {
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
