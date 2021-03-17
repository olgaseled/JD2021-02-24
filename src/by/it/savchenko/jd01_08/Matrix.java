package by.it.savchenko.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private final double[][] value;

    Matrix(double[][] value) {
        this.value = value;

    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        value = new double[][]{{1, 2}, {3, 4}};
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (double i = 1; i <= 2; i++) {
            sb.append(delimiter).append(i);
            delimiter = ",";
        }
        sb.append("},{");
        delimiter = "";
        for (double j = 3; j <= 4; j++) {
            sb.append(delimiter).append(j);
            delimiter = ",";
        }
        sb.append("}}");
        return sb.toString();
    }
}