package by.it.kaminskii.jd01_08;

import java.util.Arrays;

class Matrix extends by.it.kaminskii.jd01_08.Var {
    private final double[][] value;

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][0];
            for (int i = 0; i < res.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);

            }

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix)
            if (value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] res = new double[value.length][0];
                for (int i = 0; i < res.length; i++) {
                    res[i] = Arrays.copyOf(value[i], value[i].length);
                }

                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            } else return super.add(other);

        else if (other instanceof Vector) {
            return super.mul(other);
        }
        return super.mul(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][0];
            for (int i = 0; i < res.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);

            }

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            if (value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] res = new double[value.length][0];
                for (int i = 0; i < res.length; i++) {
                    res[i] = Arrays.copyOf(value[i], value[i].length);
                }

                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            } else return super.sub(other);
        } else return super.sub(other);
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
        } else if (other instanceof Vector) {
            if (value[0].length == ((Vector) other).getValue().length || value.length == ((Vector) other).getValue().length) {
                double[][] res = new double[value.length][0];
                for (int i = 0; i < res.length; i++) {
                    res[i] = Arrays.copyOf(value[i], value[i].length);
                }
                double[] vector = ((Vector) other).getValue();
                double[] matrixSize = new double[res.length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < vector.length; j++) {
                        matrixSize[i] += res[i][j] * vector[j];
                    }
                }
                return new Vector(matrixSize);
            } else return super.mul(other);
        } else if (other instanceof Matrix) {
            if (value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length) {
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
            } else return super.mul(other);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() != 0) {
                double[][] res = new double[value.length][0];
                for (int i = 0; i < res.length; i++) {
                    res[i] = Arrays.copyOf(value[i], value[i].length);

                }

                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j] = res[i][j] / ((Scalar) other).getValue();
                    }
                }
                return new Matrix(res);
            } else return super.div(other);
        }
        return super.div(other);
    }

    public Matrix(double[][] value) {
        this.value = new double[value.length][0];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String one = "";
        String two = "";
        strMatrix = strMatrix.replaceAll(" ", "");
        String[] matr = strMatrix.split("},\\{");
        for (int i = 0; i < matr.length; i++) {
            if (i < (matr.length - 1)) one = matr[i];
            else two = matr[i];
        }
        one = one.replaceAll("[{}]", "");
        String[] oneArray = one.split(",");
        two = two.replaceAll("[{}]", "");
        String[] twoArray = two.split(",");
        String[] both = new String[(oneArray.length + twoArray.length)];
        for (int i = 0; i < oneArray.length; i++) {
            both[i] = oneArray[i];
            both[(i + 2)] = twoArray[i];
        }
        value = new double[oneArray.length][twoArray.length];
        for (int i = 0; i < oneArray.length; i++) {
            for (int j = 0; j < oneArray.length; j++) {
                if (i < (oneArray.length - 1)) value[i][j] = Double.parseDouble(oneArray[j]);
                else value[i][j] = Double.parseDouble(twoArray[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb2 = new StringBuilder("{");
        String delim2 = "";
        int j;
        for (int i = 0; i < value.length; i++) {
            sb2.append(delim2).append("{");
            for (j = 0; j < value[0].length; j++) {
                double elem = value[i][j];
                sb2.append(delim2).append(elem);
                delim2 = ", ";
            }
            if (i < (value.length - 1)) {
                sb2.append("}").append(delim2);
                delim2 = "";
            } else {
                sb2.append("}}");
            }


        }

        return sb2.toString();
    }
}


//  StringBuilder sb=new StringBuilder("{");
//        String delim = "";
//        for(double element:value){
//            sb.append(delim).append(element);
//            delim=", ";
//        }
//        sb.append("}");
//        return sb.toString();


//разработайте для класса Var наследника Matrix с тремя конструкторами:
//1. Из массива { { 1.0, 2.0 }, { 3.0, 4.0 } } сигнатура Matrix(double[ ][ ] value)
//2. Из такой же точно переменной сигнатура Matrix(Matrix matrix)
//3. Из строки вида { { 1.0, 2.0 }, { 3.0, 4.0 } } сигнатура Matrix(String strMatrix)
// Переопределите метод String toString() так, чтобы он возвращал строку вида { { 1.0, 2.0 }, { 3.0, 4.0 } }