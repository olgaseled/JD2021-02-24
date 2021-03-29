package by.it.korotkevich.calc;

import java.util.Arrays;

class Matrix extends Var {
    private final double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }


    Matrix(Matrix matrix) {
        this.value = matrix.value;
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
        this.value = matrix;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] += secondScalar;
                }
            }
            return new Matrix(resultMatrix);
        } else if (other instanceof Matrix) {
            double[][] secondMatrix = ((Matrix) other).getValue();
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            if (resultMatrix.length != secondMatrix.length) {
                return super.add(other);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                if (resultMatrix[i].length != secondMatrix[i].length) {
                    return super.add(other);
                }
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < secondMatrix[0].length; j++) {
                    resultMatrix[i][j] = resultMatrix[i][j] + secondMatrix[i][j];
                }
            }
            return new Matrix(resultMatrix);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] -= secondScalar;
                }
            }
            return new Matrix(resultMatrix);
        } else if (other instanceof Matrix) {
            double[][] secondMatrix = ((Matrix) other).getValue();
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            if (resultMatrix.length != secondMatrix.length) {
                return super.add(other);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                if (resultMatrix[i].length != secondMatrix[i].length) {
                    return super.add(other);
                }
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < secondMatrix[0].length; j++) {
                    resultMatrix[i][j] = resultMatrix[i][j] - secondMatrix[i][j];
                }
            }
            return new Matrix(resultMatrix);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] *= secondScalar;
                }
            }
            return new Matrix(resultMatrix);
        } else if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).getValue();
            double[][] matrix = new double[value.length][value[0].length];
            double[] resultVector = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                matrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            if (matrix.length != secondVector.length) {
                return super.add(other);
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < secondVector.length; j++) {
                    resultVector[i] = resultVector[i] + matrix[i][j] * secondVector[j];
                }
            }
            return new Vector(resultVector);
        } else if (other instanceof Matrix) {
            double[][] secondMatrix = ((Matrix) other).getValue();
            double[][] firstMatrix = new double[value.length][value[0].length];
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                firstMatrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            if (firstMatrix[0].length != secondMatrix.length) {
                return super.add(other);
            }
            for (int i = 0; i < firstMatrix.length; i++) {
                if (firstMatrix[i].length != secondMatrix[i].length) {
                    return super.add(other);
                }
            }
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < secondMatrix[0].length; j++) {
                    for (int k = 0; k < secondMatrix.length; k++) {
                        resultMatrix[i][j] = resultMatrix[i][j] + firstMatrix[i][k] * secondMatrix[k][j];
                    }
                }
            }
            return new Matrix(resultMatrix);
        } else {
            return super.add(other);
        }
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{");

        for (int i = 0; i < value[0].length; i++) {
            resultString.append("{");

            for (int j = 0; j < value[1].length; j++) {
                resultString.append(value[i][j]);
                if (j != value.length - 1) {
                    resultString.append(", ");
                }
            }

            resultString.append("}");

            if (i != value[0].length - 1) {
                resultString.append(", ");
            }
        }

        resultString.append("}");
        return resultString.toString();
    }

    public double[][] getValue() {
        return value;
    }
}
