package by.it.kirichenko.jd01_08;

import java.util.StringJoiner;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    @Override
    public String toString() {
        int numberRows = value.length;
        int numberColumns = value[0].length;

        StringJoiner[] stringJoinerRows = new StringJoiner[numberRows];
        for (int i = 0; i < stringJoinerRows.length; i++) {
            stringJoinerRows[i] = new StringJoiner(", ", "{", "}");
        }
        StringJoiner stringJoinerAll = new StringJoiner(", ", "{", "}");

        for (int row = 0; row < numberRows; row++) {
            for (int column = 0; column < numberColumns; column++) {
                String s = String.valueOf(value[row][column]);
                stringJoinerRows[row].add(s);
            }
        }
        for (StringJoiner stringJoinerRow : stringJoinerRows) {
            stringJoinerAll.add(stringJoinerRow.toString());
        }

        return stringJoinerAll.toString();
    }
}
