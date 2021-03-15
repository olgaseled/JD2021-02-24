package by.it.kirichenko.jd01_08;

import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    public Vector(String str) {
        String[] arrayStr = str
                .replace("{","")
                .replace("}","")
                .replace(" ","")
                .split(",");
        double[] arrayDouble= new double[arrayStr.length];
        for (int i = 0; i < arrayStr.length; i++) {
            arrayDouble[i]=Double.parseDouble(arrayStr[i]);
        }
        this.value=arrayDouble;
    }

    @Override
    public String toString() {
        // {1.0, 3.5, 5.8}

        /*
        StringBuilder strVector = new StringBuilder("{");
        String delimiter = "";
        for (int v : value) {
            strVector.append(delimiter).append(v);
            delimiter = ", ";
        }
        strVector.append("}");
        */

        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Double v : value) {
            stringJoiner.add(v.toString());
        }

        return stringJoiner.toString();
    }
}
