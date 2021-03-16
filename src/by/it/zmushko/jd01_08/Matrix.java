package by.it.zmushko.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    public double[][] getValuesDoubleArray() {
        return valuesDoubleArray;
    }

    private final double[][] valuesDoubleArray;

    Matrix(double[][] doubleArray) {
        this.valuesDoubleArray = Arrays.copyOf(doubleArray, doubleArray.length);

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
                } else if (j == valuesDoubleArray[0].length - 1) {
                    rezString.append("}");
                }
            }
            if (i != valuesDoubleArray.length - 1) {
                rezString.append(", ");
            }
        }
        rezString.append("}");
        return rezString.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double secondOperator = ((Scalar) other).getValue();
            double[][] resultArray = Arrays.copyOf(valuesDoubleArray, valuesDoubleArray.length);
            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < resultArray.length; j++) {
                    resultArray[i][j] += secondOperator;
                }
            }
            return new Matrix(resultArray);
        }
        if (other instanceof Matrix) {
            double[][] secondOperator = ((Matrix) other).getValuesDoubleArray();
            double[][] resultArray = Arrays.copyOf(valuesDoubleArray, valuesDoubleArray.length);
            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < resultArray.length; j++) {
                    resultArray[i][j] += secondOperator[i][j];
                }
            }
            return new Matrix(resultArray);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double secondOperator = ((Scalar) other).getValue();
            double[][] resultArray = Arrays.copyOf(valuesDoubleArray, valuesDoubleArray.length);
            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < resultArray.length; j++) {
                    resultArray[i][j] -= secondOperator;
                }
            }
            return new Matrix(resultArray);
        }
        if (other instanceof Matrix) {
            double[][] secondOperator = ((Matrix) other).getValuesDoubleArray();
            double[][] resultArray = Arrays.copyOf(valuesDoubleArray, valuesDoubleArray.length);
            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < resultArray.length; j++) {
                    resultArray[i][j] -= secondOperator[i][j];
                }
            }
            return new Matrix(resultArray);
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double secondOperator = ((Scalar) other).getValue();
            double[][] resultArray = Arrays.copyOf(valuesDoubleArray, valuesDoubleArray.length);
            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < resultArray.length; j++) {
                    resultArray[i][j] *= secondOperator;
                }
            }
            return new Matrix(resultArray);
        }
        if (other instanceof Vector) {
            double[] secondOperator = ((Vector) other).getValues();
            double[][] firstOperator = Arrays.copyOf(valuesDoubleArray, valuesDoubleArray.length);
            double[] arrayAfterMultiplication = new double[firstOperator.length];
            for (int i = 0; i < firstOperator.length; i++) {
                for (int j = 0; j < secondOperator.length; j++) {
                    arrayAfterMultiplication[i] += firstOperator[i][j] * secondOperator[j];
                }
            }
            return new Vector(arrayAfterMultiplication);
        }
        if (other instanceof Matrix) {
            double[][] secondArray = ((Matrix) other).getValuesDoubleArray();
            double[][] firstArray = Arrays.copyOf(this.valuesDoubleArray, this.valuesDoubleArray.length);
            double[][] resultArray = new double[firstArray.length][secondArray[0].length];
            for (int i = 0; i < firstArray.length; i++) {
                for (int j = 0; j < secondArray[0].length; j++) {
                    for (int k = 0; k < secondArray.length; k++) {
                        resultArray[i][j] += firstArray[i][k] * secondArray[k][j];
                    }
                }
            }
            return new Matrix(resultArray);
        }
        return other.mul(this);
    }
}
