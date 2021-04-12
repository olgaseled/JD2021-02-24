package by.it.seledtsova.jd01_07;

import java.util.Arrays;

public class  Matrix extends Var {

    public final double[][] arrayValues; // приватное поле для матрицы


    public Matrix(double[][] value) {
        this.arrayValues = new double[value.length][0];
        for (int i = 0; i < value.length; i++) {
            this.arrayValues[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    Matrix (Matrix matrix) {
        this.arrayValues= matrix.arrayValues;
    }

    Matrix(String strMatrix) {
        String[] matrixRows = strMatrix.split("},");
        int rowCount = matrixRows.length;
        int colCount = matrixRows[0].split(",").length;
        double[][] matrix = new double[rowCount][colCount];

        for (int i = 0; i < matrixRows.length; i++) {
            matrixRows[i] = matrixRows[i].replaceAll("[{}]", "");
        }

        for (int i = 0; i < matrix[0].length; i++) {
            String[] arrayCols = matrixRows[i].split(",");
            for (int j = 0; j < arrayCols.length; j++) {
                matrix[i][j] = Double.parseDouble(arrayCols[j]);
            }
        }
        this.arrayValues = matrix;
    }

    @Override
    public String toString() { // написали наш массив в строку
        return Arrays.deepToString(arrayValues).replace("[", "{").replace("]", "}");
    }

    }

