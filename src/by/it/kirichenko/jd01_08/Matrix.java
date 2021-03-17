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

    public Matrix(String otherMatrix) {
        String[] arrayRows = otherMatrix.split("},");
        int rowCount = arrayRows.length;
        int colCount = arrayRows[0].split(",").length;
        double[][] matrix = new double[rowCount][colCount];

        for (int i = 0; i < arrayRows.length; i++) {
            arrayRows[i] = arrayRows[i].replaceAll("[{}]", "");
        }

        for (int i = 0; i < matrix[0].length; i++) {
            String[] arrayCols = arrayRows[i].split(",");
            for (int j = 0; j < arrayCols.length; j++) {
                matrix[i][j] = Double.parseDouble(arrayCols[j]);
            }
        }
        this.value = matrix;
    }

    @Override
    public Var add(Var otherMartix) {
        if (otherMartix instanceof Scalar) {
            double secondScalar = ((Scalar) otherMartix).getValue();
            double[][] resultMatrix = copyMatrix(value);
            int numberRows = resultMatrix.length;
            int numberColumns = resultMatrix[0].length;
            for (int row = 0; row < numberRows; row++) {
                for (int column = 0; column < numberColumns; column++) {
                    resultMatrix[row][column]+=secondScalar;
                }
            }
            return new Matrix(resultMatrix);
        }
        if (otherMartix instanceof Vector){
            return null; //TODO не возможная операция мартица + верктор
        }
        if (otherMartix instanceof Matrix){

            double[][] secondMatrix = copyMatrix(((Matrix) otherMartix).value);
            double[][] resultMatrix = copyMatrix(value);
            int numberRows = resultMatrix.length;
            int numberColumns = resultMatrix[0].length;
            for (int row = 0; row < numberRows; row++) {
                for (int column = 0; column < numberColumns; column++) {
                    resultMatrix[row][column]+=secondMatrix[row][column];
                }
            }
            return new Matrix(resultMatrix);
        }
        return super.add(otherMartix);
    }

    @Override
    public Var sub(Var otherMartix) {
        if (otherMartix instanceof Scalar) {
            double secondScalar = ((Scalar) otherMartix).getValue();
            double[][] resultMatrix = copyMatrix(value);
            int numberRows = resultMatrix.length;
            int numberColumns = resultMatrix[0].length;
            for (int row = 0; row < numberRows; row++) {
                for (int column = 0; column < numberColumns; column++) {
                    resultMatrix[row][column]-=secondScalar;
                }
            }
            return new Matrix(resultMatrix);
        }
        if (otherMartix instanceof Vector){
            return null; //TODO не возможная операция мартица + верктор
        }
        if (otherMartix instanceof Matrix){

            double[][] secondMatrix = copyMatrix(((Matrix) otherMartix).value);
            double[][] resultMatrix = copyMatrix(value);
            int numberRows = resultMatrix.length;
            int numberColumns = resultMatrix[0].length;
            for (int row = 0; row < numberRows; row++) {
                for (int column = 0; column < numberColumns; column++) {
                    resultMatrix[row][column]-=secondMatrix[row][column];
                }
            }
            return new Matrix(resultMatrix);
        }
        return super.add(otherMartix);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][0];
            for (int i = 0; i < res.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);

            }

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }

            return new Matrix(res);
        }
        else if (other instanceof Vector) {
            if(value[0].length ==((Vector) other).getValue().length || value.length==((Vector) other).getValue().length) {
                double[][] res = new double[value.length][0];
                for (int i = 0; i < res.length; i++) {
                    res[i] = Arrays.copyOf(value[i], value[i].length);
                }
                double vector[] = ((Vector) other).getValue();
                double[] matrixSize = new double[res.length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < vector.length; j++) {
                        matrixSize[i] += res[i][j] * vector[j];
                    }
                }
                return new Vector(matrixSize);
            }
            else return super.mul(other);
        }
        else if(other instanceof Matrix) {
            if(value.length == ((Matrix) other).value.length && value[0].length== ((Matrix) other).value[0].length) {
                double[][] res = new double[value.length][0];
                double[][] last = new double[res.length][((Matrix) other).value[0].length];
                for (int i = 0; i < res.length; i++) {
                    res[i] = Arrays.copyOf(value[i], value[i].length);
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < ((Matrix) other).value.length; k++) {
                            last[i][j] += res[i][k] * ((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(last);
            }
            else return super.mul(other);
        }
        else return super.mul(other);
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

    public double[][] copyMatrix(double[][] src) {
        double[][] dst = new double[src.length][];
        for (int i = 0; i < src.length; i++) {
            dst[i] = Arrays.copyOf(src[i], src[i].length);
        }
        return dst;
    }
}
