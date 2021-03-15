package by.it.belazarovich.jd01_08;

import java.util.StringJoiner;

class Vector extends Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = value;
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