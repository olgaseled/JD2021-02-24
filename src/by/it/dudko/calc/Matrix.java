package by.it.dudko.calc;

import java.util.StringJoiner;

import static by.it.dudko.calc.Utils.*;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = copyMatrix(matrix.value);
    }

    public Matrix(String strMatrix) {
        this.value = castAsMatrixOfDoubles(strMatrix);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] result = copyMatrix(this.value);
            double addendum = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += addendum;
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix) {
            double[][] addendum = ((Matrix) other).value;
            double[][] result = copyMatrix(this.value);
            if (result.length != addendum.length ||
                    result[0].length != addendum[0].length) {
                return null; // TODO add incompatible matrices exception
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += addendum[i][j];
                }
            }
            return new Matrix(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            return this.add(other.mul(new Scalar("-1")));
        }
        if (other instanceof Matrix) {
            double[][] result = copyMatrix(this.value);
            double[][] subtraction = ((Matrix) other).value;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] -= subtraction[i][j];
                }
            }
            return new Matrix(result);
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] result = copyMatrix(this.value);
            double multiplier = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= multiplier;
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix) {
            double[][] left = this.value;
            double[][] right = ((Matrix) other).value;
            if (left[0].length != right.length) {
                return null; // TODO add incompatible matrices exception
            }
            double[][] result = new double[left.length][right[0].length];
            for (int i = 0; i < left.length; i++) {
                for (int j = 0; j < right[0].length; j++) {
                    for (int k = 0; k < right.length; k++) {
                        result[i][j] = result[i][j] + left[i][k] * right[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Vector) {
            double[][] left = this.value;
            double[] right = ((Vector) other).getValue();
            if (left[0].length != right.length) {
                return null; // TODO add incompatible matrices exception
            }
            double[] result = new double[right.length];
            for (int i = 0; i < left.length; i++) {
                for (int j = 0; j < right.length; j++) {
                    result[i] += left[i][j] * right[j];
                }
            }
            return new Vector(result);
        }
        return super.div(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (double[] item : value) {
            stringJoiner.add(stringifyArray(item));
        }
        return stringJoiner.toString();
    }


    private double[][] castAsMatrixOfDoubles(String strMatrix) {
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

}
