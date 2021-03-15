package by.it.dudko.jd01_07;

import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }


    public Vector(Vector vector) {
        this.value = vector.value;
    }


    public Vector(String strVector) {
        this.value = castAsVectorOfDoubles(strVector);
    }


    private double[] castAsVectorOfDoubles(String strVector) {
        strVector = Utils.trimBraces(strVector);
        String[] strVectorItems = Utils.splitToRowItems(strVector);
        double[] vector = new double[strVectorItems.length];
        for (int i = 0; i < strVectorItems.length; i++) {
            vector[i] = Double.parseDouble(strVectorItems[i]);
        }
        return vector;
    }


    @Override
    public String toString() {
        return Utils.stringifyArray(value);
    }
}
