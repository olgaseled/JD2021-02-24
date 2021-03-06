package by.it.seledtsova.jd02_06.TaskB;

import java.util.Arrays;

public class  Matrix extends Var {



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
         public double[][] getArrayValues() {
            return arrayValues;
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
        public Var add(Var other) throws CaltExeption {
        if (other instanceof Scalar) {
            double[] [] res = new double[arrayValues.length][0];
            for (int i = 0; i < res.length; i++) {
               for (int j = 0; j < res.length; j++) {
                 res[i][j] = res[i][j] + ((Scalar) other).getValue(); // к каждому элементу этого массива добавим скаляр и добавили геттер для велью
                }
            }
                     return new Matrix(res);
            } else if (other instanceof Matrix) {
                double[][] second =((Matrix)other).arrayValues;
                double[][] res= new double[second.length][0];
             for (int i = 0; i < second.length; i++) {
                   res [i] = Arrays.copyOf(second[i],second[i].length);
              }
               for (int i = 0; i < res.length; i++) {
                   for (int j = 0; j < second.length; j++) {
                        res[i][j] = res[i][j] + second[i][j];
                }
                }
                return new Matrix(res);
            }
            return other.add(this);
        }
    private double[][] copyMatrix(double[][] value){
            double[][] resust = new double[value.length][0];
            for (int i = 0; i < resust.length; i++) {
                if (resust[i].length >= 0)
                    System.arraycopy(value[i], 0, resust[i], 0, resust[i].length);
            }
            return resust;
            }

    @Override
    public Var sub(Var other) throws CaltExeption {
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
    public Var mul(Var other) throws CaltExeption {
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

