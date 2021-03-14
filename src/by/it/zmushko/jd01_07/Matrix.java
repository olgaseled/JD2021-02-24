package by.it.zmushko.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {

    private final double[][] valuesDoubleArray;

    Matrix(double[][] doubleArray) {
        this.valuesDoubleArray = doubleArray;
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
        valuesDoubleArray = resultDoubleArray; // затык, не забудь убрать
    }

    Matrix(Matrix matrix) {
        this.valuesDoubleArray = matrix.valuesDoubleArray;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(valuesDoubleArray).replace("[", "{").replace("]", "}");
    }


}
