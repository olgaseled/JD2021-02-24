package by.it.levchuk.levchuk.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var {
    private final double[] value;


    Vector(double[] value) {
        this.value = value;
    }
    Vector(Vector vector){
        this.value= vector.value;
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