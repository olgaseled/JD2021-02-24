package by.it.zmushko.calculator;

import java.util.Arrays;

public class Vector extends Var {

    public double[] getValues() {
        return values;
    }

    private final double[] values;

    Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    Vector(Vector strVector) {
        this(strVector.values);
    }

    Vector(String strVector) {
        String changeString = strVector.replaceAll("[{}]", "").replaceAll(" ", "");
        String[] tempStringArray = changeString.split(",");
        double[] tempDoubleArray = new double[tempStringArray.length];
        for (int i = 0; i < tempStringArray.length; i++) {
            tempDoubleArray[i] = Double.parseDouble(tempStringArray[i]);
        }
        values = tempDoubleArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(values).replace("[", "{").replace("]", "}");
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(values, values.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondScalar;
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector) {
            if (this.values.length == ((Vector) other).values.length) {
                double[] secondVector = ((Vector) other).values;
                double[] resultVector = Arrays.copyOf(values, values.length);
                for (int i = 0; i < resultVector.length; i++) {
                    resultVector[i] += secondVector[i];
                }
                return new Vector(resultVector);
            }
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(values, values.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] *= secondScalar;
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector) {
            if (this.values.length == ((Vector) other).values.length) {
                double resultSum = 0;
                for (int i = 0; i < this.values.length; i++) {
                    resultSum += this.values[i] * ((Vector) other).values[i];
                }
                return new Scalar(resultSum);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(values, values.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] -= secondScalar;
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector) {
            if (this.values.length == ((Vector) other).values.length) {
                double[] resultVector = Arrays.copyOf(values, values.length);
                for (int i = 0; i < this.values.length; i++) {
                    resultVector[i] -= ((Vector) other).values[i];
                }
                return new Vector(resultVector);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(values, values.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] /= secondScalar;
            }
            return new Vector(resultVector);
        }
        return super.div(other);
    }
}
