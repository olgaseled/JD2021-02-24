package by.it.runcov.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector){
        String [] strArray=strVector.trim()
                .replaceAll("\\s+","")
                .replace("{","")
                .replace("}","")
                .split(",");
        value=new double[strArray.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(strArray[i]);
        }
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
