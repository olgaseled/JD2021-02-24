package by.it.papruga.jd01_07;

import java.util.StringJoiner;

public class Matrix extends Var {


    private double[][] value;

    public Matrix(double[][] value) {

        this.value = value;
    }

    public Matrix(Matrix otherMatrix) {

        this.value = otherMatrix.value;
    }

    public Matrix(String strMatrix) {





    }


    @Override
    public String toString() {


        StringJoiner stringJoiner = new StringJoiner(", ", "{{", "},");
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
