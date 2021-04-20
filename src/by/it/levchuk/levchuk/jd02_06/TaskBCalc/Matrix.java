package by.it.levchuk.levchuk.jd02_06.TaskBCalc;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Arrays;

public class Matrix extends Var {

    private final double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    public double[][] getValue() {
        return value;
    }

    public Matrix(String strMatrix) {
        String[] matrix = strMatrix.replaceAll(" ", "").split("[}]+[,]+[{]");
        if (matrix.length == 2) {
            matrix[0] = matrix[0].replaceAll("[{}]", "");
            matrix[1] = matrix[1].replaceAll("[{}]", "");
            String[] vector1 = matrix[0].split("[,]");
            String[] vector2 = matrix[1].split("[,]");
            double[][] mas = new double[vector1.length][vector2.length];
            for (int i = 0; i < vector1.length; i++) {
                mas[0][i] = Double.parseDouble(vector1[i]);
            }
            for (int i = 0; i < vector2.length; i++) {
                mas[1][i] = Double.parseDouble(vector2[i]);
            }
            this.value = mas;
        } else if (matrix.length == 3) {
            matrix[0] = matrix[0].replaceAll("[{}]", "");
            matrix[1] = matrix[1].replaceAll("[{}]", "");
            matrix[2] = matrix[2].replaceAll("[{}]", "");
            String[] vector1 = matrix[0].split("[,]");
            String[] vector2 = matrix[1].split("[,]");
            String[] vector3 = matrix[2].split("[,]");
            double[][] mas = new double[vector1.length][vector2.length];
            for (int i = 0; i < vector1.length; i++) {
                mas[0][i] = Double.parseDouble(vector1[i]);
            }
            for (int i = 0; i < vector2.length; i++) {
                mas[1][i] = Double.parseDouble(vector2[i]);
            }
            for (int i = 0; i < vector3.length; i++) {
                mas[2][i] = Double.parseDouble(vector3[i]);
            }
            this.value = mas;
        } else this.value = null;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector)
            return super.add(other);
        else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length) {
                double[][] res = new double[value.length][0];
                for (int i = 0; i < value.length; i++) {
                    res[i] = Arrays.copyOf(value[i], value[i].length);
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            } else return super.add(other);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector)
            return super.sub(other);
        else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length) {
                double[][] res = new double[value.length][0];
                for (int i = 0; i < value.length; i++) {
                    res[i] = Arrays.copyOf(value[i], value[i].length);
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            } else return super.sub(other);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).getValue().length) {
                double[] res = new double[((Vector) other).getValue().length];
                for (int j = 0; j < value[0].length; j++) {
                    for (int k = 0; k < value.length; k++) {
                        res[j] += this.value[j][k] * ((Vector) other).getValue()[k];
                    }
                }
                return new Vector(res);
            } else return super.mul(other);
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length) {
                double[][] res = new double[this.value.length][((Matrix) other).value.length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < value[0].length; j++) {
                        for (int k = 0; k < value.length; k++) {
                            res[i][j] += this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(res);
            } else return super.mul(other);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            return super.div(other);
        } else if (other instanceof Matrix) {
            return super.div(other);
        } else return super.div(other);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(value)
                .replace('[', '{')
                .replace(']', '}');
    }
}

