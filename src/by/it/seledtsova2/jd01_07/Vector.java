package by.it.seledtsova2.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    Vector (String strValue) {
        String [] arrayString=strValue.replaceAll("[{} ]+","").trim().split(",");
        double[] result = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            result[i]=Double.parseDouble(arrayString[i]);
        }
        this.value = result;

    }




    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            stringBuilder.append(delimiter).append(element);
            delimiter = ", ";
        }

        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
