package by.it.seledtsova.jd01_08;

import java.util.Arrays;

public class  Matrix extends Var {


        public double[][] getArrayValues() {
            return arrayValues;
        }

        public double[][] getValue() {
            return arrayValues;
        }
        private final double[][] arrayValues;

        public Matrix(double[][] value) {
            this.arrayValues = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                this.arrayValues[i] = Arrays.copyOf(value[i], value[i].length);
            }
        }

        public Matrix(String strValue) {
            this(new double[][]{{1, 2}, {3, 4}}); //stub
        }

        @Override
        public String toString() {
            return Arrays.deepToString(arrayValues).replace("[", "{").replace("]", "}");
        }

    @Override
    protected double[] getValues() {
        return new double[0];
    }

    @Override
        public Var add(Var other) {
            if (other instanceof Scalar) {
                double second=((Scalar)other).getValue();
                double[][] res = new double[arrayValues.length][0];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] = res[i][j] + ((Scalar) other).getValue(); // к каждому элементу этого массива добавим скаляр и добавили геттер для велью
                    }
                }
                return new Matrix(res);
            } else if (other instanceof Matrix) {
                double[][] second = ((Matrix) other).getValue();
                double[][] res= new double[arrayValues.length][0];
                for (int i = 0; i < second.length; i++) {
                    res [i] = Arrays.copyOf(arrayValues[i],arrayValues[i].length);
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] = res[i][j] + second[i][j];
                    }
                }
                return new Matrix(res);
            }
            return other.add(this);
        }



        @Override
        public Var sub(Var other) {
            if (other instanceof Scalar) {
                double[][] res = Arrays.copyOf(arrayValues, arrayValues.length);
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] = res[i][j] - ((Scalar) other).getValue(); // к каждому элементу этого массива добавим скаляр и добавили геттер для велью
                    }
                }
                return new Matrix(res);
            } else if (other instanceof Matrix) {

                double[][] res = Arrays.copyOf(arrayValues, arrayValues.length); // если к матрице прибавляется тоже матрицу
                double[][] matrix2 = getArrayValues();
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] = res[i][j] - matrix2[j][i];
                    }
                }

                return new Matrix(res);
            }
            return other.sub(this);
        }

        @Override
        public Var mul(Var other) {
            if (other instanceof Scalar) {
                double[][] res = Arrays.copyOf(arrayValues, arrayValues.length);
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] = res[i][j] * ((Scalar) other).getValue(); // к каждому элементу этого массива добавим скаляр и добавили геттер для велью
                    }
                }
                return new Matrix(res);
            } else if (other instanceof Matrix) {

                double[][] res = Arrays.copyOf(arrayValues, arrayValues.length); // если к матрице прибавляется тоже матрицу
                double[][] matrix2 = getArrayValues();
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < matrix2[0].length; j++) {
                        for (int k = 0; k < matrix2.length; k++) {
                            res[i][j] += res[i][k]*matrix2[k][j];
                        }
                    }
                }

                return new Matrix(res);
            }
            return super.mul(other);
        }



    }




