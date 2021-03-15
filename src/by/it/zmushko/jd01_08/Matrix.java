package by.it.zmushko.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private final double[][] valuesDoubleArray;

    Matrix(double[][] doubleArray) {
        this.valuesDoubleArray = new double[doubleArray.length][0];
        for (int i = 0; i < valuesDoubleArray.length; i++) {
            this.valuesDoubleArray[i] = Arrays.copyOf(valuesDoubleArray[i], doubleArray[i].length);
        }
    }

    Matrix(String doubleStringArray) {
        String[] arrayString = doubleStringArray.trim()
                .replaceAll("\\s+", "")
                .split("},\\{"); //;
        double[][] resultDoubleArray = new double[arrayString.length][arrayString[0].split(",").length];
        for (int i = 0; i < resultDoubleArray.length; i++) {
            String arrayCols = arrayString[i].replace("{", "")
                    .replace("}", "");
            String[] arrayStringRows = arrayCols.split(",");
            for (int j = 0; j < arrayStringRows.length; j++) {
                resultDoubleArray[i][j] = Double.parseDouble(arrayStringRows[j]);
            }
        }
        this.valuesDoubleArray = resultDoubleArray;
    }


    Matrix(Matrix matrix) {
        this.valuesDoubleArray = matrix.valuesDoubleArray;
    }

    @Override
    public String toString() {
        StringBuilder rezString = new StringBuilder(); //расширяемая строка, которую можно изменять без ущерба для производительности
        rezString.append("{");
        for (int i = 0; i < valuesDoubleArray.length; i++) {
            for (int j = 0; j < valuesDoubleArray[0].length; j++) {
                if (j == 0) {
                    rezString.append("{");
                }
                rezString.append(valuesDoubleArray[i][j]);
                if (j != valuesDoubleArray[0].length - 1) {
                    rezString.append(", ");
                } else if (j == valuesDoubleArray[0].length - 1){
                    rezString.append("}");
                }
            }
            if (i != valuesDoubleArray.length -1) {
                rezString.append(", ");
            }
        }
        rezString.append("}");
        return rezString.toString();
    }

}
