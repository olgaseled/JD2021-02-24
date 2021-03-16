package by.it.kirichenko.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = new double[value.length][0];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    Matrix(String doubleStringArray) {
        String stringWithoutSpace = doubleStringArray.replaceAll(" ", "");
        String[] tempArrayString = stringWithoutSpace.split("},\\{");
        String[] tempArrayAfterSplit = new String[tempArrayString.length];
        for (int i = 0; i < tempArrayString.length; i++) {
            tempArrayAfterSplit[i] = tempArrayAfterSplit[i] + tempArrayString[i].replaceAll("[{}]", "").replaceAll(",\"", " ").split(" ");
        }
        int countElementsInTempArray = 0;
        double[][] resultDoubleArray = new double[tempArrayString.length][tempArrayString.length];
        for (int i = 0; i < resultDoubleArray.length; i++) {
            for (int j = 0; j < resultDoubleArray.length; j++) {
                resultDoubleArray[i][j] = Double.parseDouble(tempArrayAfterSplit[countElementsInTempArray++]);
            }
        }
        value = resultDoubleArray;
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
