package by.it.korotkevich.calc;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strValue) {
        String[] trimmedString = strValue.replaceAll("[{} ]+", "").trim().split(",");
        double[] result = new double[trimmedString.length];
        for (int i = 0; i < trimmedString.length; i++) {
            result[i] = Double.parseDouble(trimmedString[i]);
        }
        this.value = result;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondScalar;
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).value;
            double[] resultVector = Arrays.copyOf(value, value.length);
            if (secondVector.length != resultVector.length) {
                throw new CalcException("Incorrect size");
            }
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondVector[i];
            }
            return new Vector(resultVector);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] -= secondScalar;
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).value;
            double[] resultVector = Arrays.copyOf(value, value.length);
            if (secondVector.length != resultVector.length) {
                throw new CalcException("Incorrect size");
            }
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] -= secondVector[i];
            }
            return new Vector(resultVector);
        }
        return super.sub(other);
    }


    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] *= secondScalar;
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).value;
            double[] arrayOfNumbers = Arrays.copyOf(value, value.length);
            if (secondVector.length != arrayOfNumbers.length) {
                return super.add(other);
            }
            for (int i = 0; i < arrayOfNumbers.length; i++) {
                double firstNumber = arrayOfNumbers[i];
                double secondNumber = secondVector[i];
                arrayOfNumbers[i] = firstNumber * secondNumber;
            }
            double result = 0;
            for (double arrayOfNumber : arrayOfNumbers) {
                result += arrayOfNumber;
            }
            return new Scalar(result);
        }
        return super.add(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            if (secondScalar == 0) {
                return super.div(other);
            }
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] /= secondScalar;
            }
            return new Vector(resultVector);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Double v : value) {
            stringJoiner.add(v.toString());
        }

        return stringJoiner.toString();
    }

    public double[] getValue() {
        return value;
    }
}
