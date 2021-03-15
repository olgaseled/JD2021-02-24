package by.it.zmushko.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] values;

    Vector(double[] values) {
        this.values = values;
    }

    Vector(Vector strVector) {
        this.values = strVector.values;
    }

    Vector(String strVector) {
        //String changeString = strVector.replaceAll("[{}]", "").replaceAll(" ", "");
        //String[] tempStringArray = changeString.split(",");
        //double[] tempDoubleArray = new double[tempStringArray.length];
        //for (int i = 0; i < tempStringArray.length; i++) {
        //    tempDoubleArray[i] = Double.parseDouble(tempStringArray[i]);
        //}
        //values = tempDoubleArray;
        String[] strArray = strVector.trim()
                .replaceAll("\\s+", "")
                .replace("{", "")
                .replace("}", "")
                .split(",");
        values = new double[strArray.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(values).replace("[", "{").replace("]", "}");
    }
}
