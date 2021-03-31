package by.it.kirichenko.calc;

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
    public Var add(Var otherMartix) throws CalcException {
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
    public Var sub(Var otherMartix) throws CalcException {
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
        return super.sub(otherMartix);
    }

    @Override
    public Var mul(Var otherMartix) throws CalcException {
        if (otherMartix instanceof Scalar) {
            double secondScalar = ((Scalar) otherMartix).getValue();
            double[][] resultMatrix = copyMatrix(value);
            int numberRows = resultMatrix.length;
            int numberColumns = resultMatrix[0].length;
            for (int row = 0; row < numberRows; row++) {
                for (int column = 0; column < numberColumns; column++) {
                    resultMatrix[row][column]*=secondScalar;
                }
            }
            return new Matrix(resultMatrix);
        }
        if (otherMartix instanceof Vector) {
            if(value[0].length ==((Vector) otherMartix).getValue().length || value.length==((Vector) otherMartix).getValue().length) {
                double[][] resultMatrix = copyMatrix(value);
                double vector[] = ((Vector) otherMartix).getValue();
                double[] matrixSize = new double[resultMatrix.length];
                for (int i = 0; i < resultMatrix.length; i++) {
                    for (int j = 0; j < vector.length; j++) {
                        matrixSize[i] += resultMatrix[i][j] * vector[j];
                    }
                }
                return new Vector(matrixSize);
            }
            else return super.mul(otherMartix);
        }
        if(otherMartix instanceof Matrix) {
            if(value.length == ((Matrix) otherMartix).value.length && value[0].length== ((Matrix) otherMartix).value[0].length) {
                double[][] tmpMatrix = copyMatrix(value);
                double[][] resultMatrix = new double[tmpMatrix.length][((Matrix) otherMartix).value[0].length];
                for (int i = 0; i < tmpMatrix.length; i++) {
                    for (int j = 0; j < ((Matrix) otherMartix).value[0].length; j++) {
                        for (int k = 0; k < ((Matrix) otherMartix).value.length; k++) {
                            resultMatrix[i][j] += tmpMatrix[i][k] * ((Matrix) otherMartix).value[k][j];
                        }
                    }
                }
                return new Matrix(resultMatrix);
            }
            else return super.mul(otherMartix);
        }
        return super.mul(otherMartix);
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
