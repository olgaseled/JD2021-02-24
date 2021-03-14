package by.it.korotkevich.jd01_07;

import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector otherVector) {this.value = otherVector.value; }

    Vector(String strValue) {
        String[] trimmedString = strValue.replaceAll("[{} ]+", "").trim().split(",");
        double[] result = new double[trimmedString.length];
        for (int i = 0; i < trimmedString.length; i++) {
            result[i]=Double.parseDouble(trimmedString[i]);
        }
        this.value = result;
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
