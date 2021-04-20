package by.it.runcov.jd02_06.calc;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var {

    private final double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(String strVector) {
        String[] strArray = strVector.trim()
                .replaceAll("\\s+", "")
                .replace("{", "")
                .replace("}", "")
                .split(",");
        value = new double[strArray.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
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
            if (this.value.length != secondVector.length) {
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
            if (this.value.length != secondVector.length) {
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
            double resultVector = 0;
            for (int i = 0; i < value.length; i++) {
                resultVector += value[i] * secondVector[i];
            }
            return new Scalar(resultVector);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            if (secondScalar == 0) {
                throw new CalcException("Prohibited operation");
            }
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] /= secondScalar;
            }
            return new Vector(resultVector);
        }

        return super.div(other);
    }


    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Double element : value) {
            stringJoiner.add(element.toString());
        }
        return stringJoiner.toString();
    }
}
