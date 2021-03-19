package by.it.seledtsova.jd01_07;

import java.util.Arrays;

public class  Matrix extends Var {

    public final double[][] arrayValues; // приватное поле для матрицы


    public Matrix(double[][] value) {
        this.arrayValues = new double[value.length][0];
        for (int i = 0; i < value.length; i++) {
            this.arrayValues[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    Matrix (Matrix matrix) {
        this.arrayValues= matrix.arrayValues;
    }

    public Matrix(String strValue) {
        this(new double[][]{{1, 2}, {3, 4}}); //stub
    }

    @Override
    public String toString() { // написали наш массив в строку
        return Arrays.deepToString(arrayValues).replace("[", "{").replace("]", "}");
    }

    }

