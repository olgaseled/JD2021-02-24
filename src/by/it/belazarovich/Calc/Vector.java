package by.it.belazarovich.Calc;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends by.it.belazarovich.jd01_08.Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    @Override
    public by.it.belazarovich.jd01_08.Var add(by.it.belazarovich.jd01_08.Var other) {
        if (other instanceof by.it.belazarovich.jd01_08.Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++)
                res[i] = res[i] + ((by.it.belazarovich.jd01_08.Scalar) other).getValue();
            return new Vector(res);

        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
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