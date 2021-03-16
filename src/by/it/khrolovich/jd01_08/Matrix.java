package by.it.khrolovich.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private final double[][] value;

    //копируем, а не просто ссылка. Так лучше!
    public Matrix(double[][] value) {
        double[][] resultMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
        }
        this.value = resultMatrix;
        // this.value = doubles;//простой вариант
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    public Matrix(String s) {
        s = s.trim().replaceAll("\\s+", "");//нет пробелов
        s = s.replace("{{", "").replace("}}", "");
        String[] Rows = s.split("\\}\\,\\{");

        double[][] MatrisOfS = new double[Rows.length][];
        int i = 0;
        for (String s1 : Rows) {
            String[] Collumns = s1.split(",");

            MatrisOfS[i] = new double[Collumns.length];

            for (int j = 0; j < Collumns.length; j++) {
                MatrisOfS[i][j] = Double.parseDouble(Collumns[j]);
            }
            i++;
        }

        this.value = MatrisOfS;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(resultMatrix);
        }
        if (other instanceof Matrix) {
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            //TODO условие на длины
            double[][] secondMatrix = ((Matrix) other).value;
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] += secondMatrix[i][j];
                }
            }
            return new Matrix(resultMatrix);
        }

        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(resultMatrix);
        }
        if (other instanceof Matrix) {
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double[][] secondMatrix = ((Matrix) other).value;
            //TODO добавить условие
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] -= secondMatrix[i][j];
                }
            }
            return new Matrix(resultMatrix);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        double[][] resultMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            resultMatrix[i] = Arrays.copyOf(value[i], value[i].length);
        }
        if(other instanceof Scalar){
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j]*=((Scalar) other).getValue();
                }
            }
            return new Matrix(resultMatrix);
        }
        if(other instanceof Vector){
            double[] resultVector = new double[resultMatrix.length];
            double[] otherVector =  ((Vector) other).getValue();
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultVector[i] += resultMatrix[i][j]*otherVector[j];
                }
            }
            return new Vector(resultVector);
        }
        if(other instanceof Matrix){
            double[][] secondMatrix = ((Matrix) other).value;
            double[][] newMatrix = new double[resultMatrix.length][secondMatrix[0].length];
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    for (int k = 0; k < secondMatrix[j].length; k++) {
                        newMatrix[i][k]+=resultMatrix[i][j]*secondMatrix[j][k];
                    }
                }
            }
            return new Matrix(newMatrix);
        }
        return super.mul(other);
    }

    @Override
    public String toString() {

        StringJoiner stringJoiner2 = new StringJoiner(", ", "{", "}");
        for (double[] doubles : value) {
            StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
            for (Double v1 : doubles) {
                stringJoiner.add(v1.toString());
            }
            stringJoiner2.add(stringJoiner.toString());

        }

        return stringJoiner2.toString();
    }
}
