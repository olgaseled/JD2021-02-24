package by.it.korotkevich.jd01_09;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var {

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
    public Var add(Var other) {
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
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondVector[i];
            }
            return new Vector(resultVector);
        }
        return super.add(other);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Double v : value) {
            stringJoiner.add(v.toString());
        }

        return stringJoiner.toString();
    }
}
