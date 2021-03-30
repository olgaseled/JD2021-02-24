package by.it.zmushko.calculator;

import java.util.Arrays;

public class Matrix extends Var {

    public double[][] getValue() {
        return value;
    }

    private final double[][] value;

    Matrix(double[][] doubleArray) {
        this.value = new double[doubleArray.length][0];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(doubleArray[i], doubleArray[i].length);
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
        this.value = resultDoubleArray;
    }


    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    @Override
    public String toString() {
        StringBuilder rezString = new StringBuilder(); //расширяемая строка, которую можно изменять без ущерба для производительности
        rezString.append("{");
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == 0) {
                    rezString.append("{");
                }
                rezString.append(value[i][j]);
                if (j != value[0].length - 1) {
                    rezString.append(", ");
                } else if (j == value[0].length - 1) {
                    rezString.append("}");
                }
            }
            if (i != value.length - 1) {
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
            double[][] resultArray = new double[value.length][0];
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] = Arrays.copyOf(value[i], value[i].length);
            }

            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < resultArray.length; j++) {
                    resultArray[i][j] += secondOperator;
                }
            }
            return new Matrix(resultArray);
        }
        if (other instanceof Matrix) {
            double[][] secondOperator = ((Matrix) other).getValue();
            double[][] resultArray = new double[value.length][0];
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] = Arrays.copyOf(value[i], value[i].length);
            }
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
            double[][] resultArray = new double[value.length][0];
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < resultArray.length; j++) {
                    resultArray[i][j] -= secondOperator;
                }
            }
            return new Matrix(resultArray);
        }
        if (other instanceof Matrix) {
            double[][] secondOperator = ((Matrix) other).getValue();
            double[][] resultArray = new double[value.length][0];
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] = Arrays.copyOf(value[i], value[i].length);
            }
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
            double[][] resultArray = new double[value.length][0];
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < resultArray.length; j++) {
                    resultArray[i][j] *= secondOperator;
                }
            }
            return new Matrix(resultArray);
        }
        if (other instanceof Vector) {
            double[] secondOperator = ((Vector) other).getValues();
            double[][] resultArray = new double[value.length][0];
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double[] arrayAfterMultiplication = new double[resultArray.length];
            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < secondOperator.length; j++) {
                    arrayAfterMultiplication[i] += resultArray[i][j] * secondOperator[j];
                }
            }
            return new Vector(arrayAfterMultiplication);
        }
        if (other instanceof Matrix) {
            double[][] secondArray = ((Matrix) other).getValue();
            double[][] firstArray = Arrays.copyOf(this.value, this.value.length);
            double[][] resultArray = new double[value.length][value[0].length];
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

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondOperator = ((Scalar) other).getValue();
            if (secondOperator != 0) {
                double[][] resultArray = new double[value.length][0];
                for (int i = 0; i < resultArray.length; i++) {
                    resultArray[i] = Arrays.copyOf(value[i], value[i].length);
                }
                for (int i = 0; i < resultArray.length; i++) {
                    for (int j = 0; j < resultArray.length; j++) {
                        resultArray[i][j] /= secondOperator;
                    }
                }
                return new Matrix(resultArray);
            }
        }
        return super.div(other);
    }
}
