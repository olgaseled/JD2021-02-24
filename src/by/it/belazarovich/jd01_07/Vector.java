package by.it.belazarovich.jd01_07;

import java.util.StringJoiner;

class Vector extends Var {
    final private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    Vector(String strVector) {

        String clean = strVector.replaceAll("[{}]", "");

        String[] num = clean.split("[,]");
        double[] mas = new double[num.length];

        for (int i = 0; i < num.length; i++) {
            mas[i] = Double.parseDouble(num[i]);
        }
        this.value = mas;

    }


    @Override
    public String toString() {
        // {1.0, 3.5, 5.8}

        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Double v : value) {
            stringJoiner.add(v.toString());
        }

        return stringJoiner.toString();

    }
}
