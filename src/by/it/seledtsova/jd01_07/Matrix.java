package by.it.seledtsova.jd01_07;

import java.util.Arrays;

public class  Matrix extends Var {

    private final double[][] arrayValues;

    Matrix(double[][] value) { // 1 конструктор на вход принемает некоторый двумерный массив
        this.arrayValues = value;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "arrayValues=" + Arrays.toString(arrayValues) +
                '}';
    }
}

