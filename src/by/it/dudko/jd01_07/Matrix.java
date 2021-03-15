package by.it.dudko.jd01_07;

import java.util.StringJoiner;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        this.value = castAsMatrixOfDoubles(strMatrix);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (double[] item : value) {
            stringJoiner.add(Utils.stringifyArray(item));
        }
        return stringJoiner.toString();
    }


    private double[][] castAsMatrixOfDoubles(String strMatrix) {
        final int m, n;
        strMatrix = Utils.trimBraces(strMatrix);
        String[] strMatrixRows = Utils.splitToMatrixRows(strMatrix);
        m = strMatrixRows.length;
        n = Utils.splitToRowItems(Utils.trimBraces(strMatrixRows[0])).length;
        double[][] matrix = new double[m][n];

        for (int i = 0; i < m; i++) {
            String strMatrixRow = Utils.trimBraces(strMatrixRows[i]);
            String[] matrixRow = Utils.splitToRowItems(strMatrixRow);
            if (n != matrixRow.length) {
                System.out.println("Provided matrix has various row length");
                continue;
            }
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Double.parseDouble(matrixRow[j]);
            }
        }
        return matrix;
    }

}
