package by.it.dudko.calc;

import java.util.Arrays;
import java.util.StringJoiner;

class Utils {
    static String trimBraces(String strMatrix) {
        return strMatrix.trim().replace(" ", "").replaceAll("(^\\{)|(}$)", "");
    }

    static String[] splitToMatrixRows(String strMatrix) {
        return strMatrix.split("},\\{");
    }

    static String[] splitToRowItems(String strRow) {
        return strRow.split("\\s*,\\s*");
    }

    static String stringifyArray(double[] arr) {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Double item : arr) {
            stringJoiner.add(item.toString());
        }
        return stringJoiner.toString();
    }

    static double[][] copyMatrix(double[][] inMatrix) {
        double[][] copyMatrix = new double[inMatrix.length][0];
        for (int i = 0; i < inMatrix.length; i++) {
            copyMatrix[i] = Arrays.copyOf(inMatrix[i], inMatrix[i].length);
        }
        return copyMatrix;
    }

    static double[][] castAsMatrixOfDoubles(String strMatrix) {
        final int m, n;
        strMatrix = trimBraces(strMatrix);
        String[] strMatrixRows = splitToMatrixRows(strMatrix);
        m = strMatrixRows.length;
        n = splitToRowItems(trimBraces(strMatrixRows[0])).length;
        double[][] matrix = new double[m][n];

        for (int i = 0; i < m; i++) {
            String strMatrixRow = trimBraces(strMatrixRows[i]);
            String[] matrixRow = splitToRowItems(strMatrixRow);
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

    static double[] castAsVectorOfDoubles(String strVector) {
        strVector = Utils.trimBraces(strVector);
        String[] strVectorItems = Utils.splitToRowItems(strVector);
        double[] vector = new double[strVectorItems.length];
        for (int i = 0; i < strVectorItems.length; i++) {
            vector[i] = Double.parseDouble(strVectorItems[i]);
        }
        return vector;
    }
}
