package by.it.belazarovich.jd01_07;

import java.util.StringJoiner;

public class Matrix extends Var {
    final private double[][] value;

    Matrix(double[][] value) {

        this.value = value;
    }

    Matrix(Matrix otherMatrix) {

        this.value = otherMatrix.value;
    }

    Matrix(String strMatrix) {


        String[] matrix = strMatrix.replaceAll(" ", "").split("[}]+[,]+[{]");

        matrix[0] = matrix[0].replaceAll("[{}]", "");
        matrix[1] = matrix[1].replaceAll("[{}]", "");

        String[] vector1 = matrix[0].split("[,]");
        String[] vector2 = matrix[1].split("[,]");

        double[][] mas = new double[vector1.length][vector2.length];

        for (int i = 0; i < vector1.length; i++) {
            mas[0][i] = Double.parseDouble(vector1[i]);
        }
        for (int i = 0; i < vector2.length; i++) {
            mas[1][i] = Double.parseDouble(vector2[i]);
        }

        this.value = mas;

    }

    @Override
    public String toString() {


        StringJoiner stringJoiner = new StringJoiner(", ", "{{", "}, ");
        for (Double v : value[0]) {
            stringJoiner.add(v.toString());
        }
        StringJoiner stringJoiner2 = new StringJoiner(", ", "{", "}}");
        for (Double v : value[1]) {
            stringJoiner2.add(v.toString());
        }

        return stringJoiner.toString() + stringJoiner2.toString();

    }
}


