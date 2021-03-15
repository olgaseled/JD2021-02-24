package by.it.runcov.jd01_08;

import java.util.StringJoiner;

class Vector extends Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
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
